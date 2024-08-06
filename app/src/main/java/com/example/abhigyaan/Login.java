package com.example.abhigyaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;
    private static final int REQ_ONE_TAP = 2;
    private DatabaseReference mDatabase;

    Button callSign, mainsubmit;
    ImageView imageView;
    TextView welcome, signup3;
    TextInputLayout usernamemain, password_togglemain;
    Button btn;
    Button newbtn;
    Vibrator vibrate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(Login.this, dashboard.class);
            startActivity(intent);
            finish();
        }

        oneTapClient = Identity.getSignInClient(this);
        signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(
                        BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                                .setSupported(true)
                                .setServerClientId("93553756518-pabvpnnrglcl9lsckn0bs028t0kblpu3.apps.googleusercontent.com")
                                .setFilterByAuthorizedAccounts(false)
                                .build())
                .build();

        mainsubmit = findViewById(R.id.mainsubmit);
        mainsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneTapClient.beginSignIn(signInRequest)
                        .addOnSuccessListener(Login.this, result -> {
                            try {
                                startIntentSenderForResult(result.getPendingIntent().getIntentSender(), REQ_ONE_TAP, null, 0, 0, 0);
                            } catch (Exception e) {
                                Log.e("Login", "Couldn't start One Tap UI: " + e.getLocalizedMessage());
                            }
                        })
                        .addOnFailureListener(Login.this, e -> {
                            Toast.makeText(Login.this, "Google Sign-In Failed: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_ONE_TAP) {
            try {
                SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(data);
                String idToken = credential.getGoogleIdToken();
                if (idToken != null) {
                    firebaseAuthWithGoogle(idToken);
                }
            } catch (ApiException e) {
                Toast.makeText(this, "Sign-In Failed: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential firebaseCredential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(firebaseCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            saveUserInfoToDatabase(user);
                            Intent intent = new Intent(Login.this, dashboard.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void saveUserInfoToDatabase(FirebaseUser user) {
        User userInfo = new User(
                user.getDisplayName(),
                user.getEmail(),
                user.getPhotoUrl() != null ? user.getPhotoUrl().toString() : null
        );

        mDatabase.child("users").child(user.getUid()).setValue(userInfo)
                .addOnSuccessListener(aVoid -> Log.d("Firebase", "User info saved successfully"))
                .addOnFailureListener(e -> Log.w("Firebase", "Error saving user info", e));
    }
}