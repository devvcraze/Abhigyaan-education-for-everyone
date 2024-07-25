package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profileActivity extends AppCompatActivity {

    private static final String TAG = "profileActivity";
    private ImageView profileImage;
    private TextView fullNameProfileLabel;
    private TextView fullNameProfileLabel2;
    private TextView classesTakenTextView;
    private Button signOutButton;
    private FirebaseAuth mAuth;
    private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = findViewById(R.id.profileImage);
        fullNameProfileLabel = findViewById(R.id.full_name_profile_label);
        fullNameProfileLabel2 = findViewById(R.id.full_name_profile_label2);
        classesTakenTextView = findViewById(R.id.classes_taken_text_view);
        signOutButton = findViewById(R.id.sign_out_button);
        mAuth = FirebaseAuth.getInstance();

        // Get current user
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // Get user's profile image and name
            String name = user.getDisplayName();
            String email = user.getEmail();
            String photoUrl = user.getPhotoUrl() != null ? user.getPhotoUrl().toString() : "";

            // Set user's name and email
            fullNameProfileLabel.setText(name);
            fullNameProfileLabel2.setText(email);

            // Load user's profile image using Glide
            Glide.with(this)
                    .load(photoUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(profileImage);

            // Reference to the user's data in Firebase Database
            userRef = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());

            // Retrieve and display the classesTaken field
            userRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        Integer classesTaken = snapshot.child("classesTaken").getValue(Integer.class);
                        if (classesTaken != null) {
                            classesTakenTextView.setText("Classes Taken: " + classesTaken);
                        } else {
                            classesTakenTextView.setText("Classes Taken: 0");
                        }
                        Log.d(TAG, "classesTaken: " + classesTaken);
                    } else {
                        classesTakenTextView.setText("Classes Taken: 0");
                        Log.d(TAG, "snapshot does not exist");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle possible errors.
                    Toast.makeText(profileActivity.this, "Failed to load data.", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "DatabaseError: " + error.getMessage());
                }
            });
        }

        // Set sign out button click listener
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out from Firebase Authentication
                mAuth.signOut();

                // Display a toast message
                Toast.makeText(profileActivity.this, "Signed out", Toast.LENGTH_SHORT).show();

                // Redirect to login screen
                Intent intent = new Intent(profileActivity.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
