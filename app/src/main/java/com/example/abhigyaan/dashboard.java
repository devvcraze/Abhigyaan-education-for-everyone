package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class dashboard extends AppCompatActivity {

    TextView verticalsText;
    TextView events_text;
    TextView gallery_text;
    TextView about_text;
    TextView coordination_text;
    TextView feedback_text;
    Vibrator vibrate;
    CardView contact;
    FloatingActionButton fabProfile;
    FloatingActionButton fabUserList;

    private FirebaseAuth mAuth;
    private List<String> authorizedEmails = Arrays.asList("hawentidevi@gmail.com", "authorized2@example.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        // Initialize the TextViews and CardView
        verticalsText = findViewById(R.id.verticals_text);
        events_text = findViewById(R.id.events_text);
        gallery_text = findViewById(R.id.gallery_text);
        about_text = findViewById(R.id.about_text);
        coordination_text = findViewById(R.id.coordination_text);
        feedback_text = findViewById(R.id.feedback_text);
        contact = findViewById(R.id.card_contact);

        // Initialize FloatingActionButtons
        fabProfile = findViewById(R.id.fab_profile);
        fabUserList = findViewById(R.id.fab_user_list);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Set OnClickListener for verticalsText
        verticalsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, VerticalsActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        // Set OnClickListener for events_text
        events_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, eventsActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        // Set OnClickListener for gallery_text
        gallery_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, galleryActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        // Set OnClickListener for about_text
        about_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, aboutActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        // Set OnClickListener for coordination_text
        coordination_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, coordinationActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        // Set OnClickListener for feedback_text
        feedback_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, feedbackActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        // Set OnClickListener for contact CardView
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, contactusActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        // Set OnClickListener for Profile FloatingActionButton
        fabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, profileActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for User List FloatingActionButton
        fabUserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAuthorizationAndOpenUserList();
            }
        });
    }

    private void checkAuthorizationAndOpenUserList() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userEmail = currentUser.getEmail();
            if (authorizedEmails.contains(userEmail)) {
                Intent intent = new Intent(dashboard.this, UserListActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(dashboard.this, "You are not authorized to view this page.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Intent intent = new Intent(dashboard.this, Login.class);
            startActivity(intent);
            finish();
        }
    }
}
