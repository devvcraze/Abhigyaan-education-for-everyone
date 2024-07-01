package com.example.abhigyaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.material.textfield.TextInputLayout;
//import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
//    private FirebaseAuth auth;
//    private static final int RC_SIGN_IN = 9001;
//    private GoogleSignInClient googleSignInClient;
    Button callSign, mainsubmit;
    ImageView imageView;
    TextView welcome, signup3;
    TextInputLayout usernamemain, password_togglemain;
    Button btn;
    Button newbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
//        auth = FirebaseAuth.getInstance();

        // Find button by ID
//        btn = findViewById(R.id.btn);
        newbtn = findViewById(R.id.newbtn);

        // Set an OnClickListener on the button
        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(Login.this, dashboard.class);
                startActivity(intent);
            }
        });
    }
}

/*        auth=FirebaseDatabase.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);*/


       /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();

            }
        });*/
/*
        callSign = findViewById(R.id.signup);
        usernamemain = findViewById(R.id.usernamemain);
        password_togglemain = findViewById(R.id.password_togglemain);
        mainsubmit=findViewById(R.id.mainsubmit);

        callSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SIGNUP.class);
                startActivity(intent);
            }
        });
    }*


   /* private void signin() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());

            }catch (ApiException e){
                Toast.makeText(this, "login failed: "+e, Toast.LENGTH_SHORT).show();

            }
        }
    }*/
   /* private void firebaseAuth(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(Login.this, features.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }*/


    /*private Boolean validatePassword() {
        String val = Objects.requireNonNull(password_togglemain.getEditText()).getText().toString();
        if (val.isEmpty()) {
            password_togglemain.setError("Field cannot be empty");
            return false;
        } else {
            password_togglemain.setError(null);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = Objects.requireNonNull(usernamemain.getEditText()).getText().toString();
        if (val.isEmpty()) {
            usernamemain.setError("Field cannot be empty");
            return false;
        } else {
            usernamemain.setError(null);
            usernamemain.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {
        if (!validateUsername() || !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }*/
/*

    private void isUser() {

        final String usernameentered = Objects.requireNonNull(usernamemain.getEditText()).getText().toString().trim();
        final String passwordentered = Objects.requireNonNull(password_togglemain.getEditText()).getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(usernameentered);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Log.d("LoginDebug", "User found");
                    usernamemain.setError(null);
                    usernamemain.setErrorEnabled(false);
                    String Passwordfromdb = snapshot.child(usernameentered).child("password").getValue(String.class);
                    assert Passwordfromdb != null;
                    if (Passwordfromdb.equals(passwordentered)) {
                        usernamemain.setError(null);
                        usernamemain.setErrorEnabled(false);
                        String namefromdb = snapshot.child(usernameentered).child("name").getValue(String.class);
                        String usernamefromdb = snapshot.child(usernameentered).child("username").getValue(String.class);
                        String phonefromdb = snapshot.child(usernameentered).child("phone").getValue(String.class);
                        String email1fromdb = snapshot.child(usernameentered).child("email").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), userprofile.class);
                        intent.putExtra("name", namefromdb);
                        intent.putExtra("username", usernamefromdb);
                        intent.putExtra("phone", phonefromdb);
                        intent.putExtra("email", email1fromdb);
                        intent.putExtra("password", Passwordfromdb);
                        startActivity(intent);
                    } else {
                        password_togglemain.setError("Wrong password");
                        password_togglemain.requestFocus();
                    }
                } else {
                    Log.d("LoginDebug", "User not found");
                    usernamemain.setError("User does not exist");
                    usernamemain.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("LoginDebug", "Database error: " + error.getMessage());
            }*/
        /*});/*
    }
}*/
