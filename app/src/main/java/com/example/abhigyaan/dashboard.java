package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dashboard extends AppCompatActivity {

    TextView verticalsText;
    TextView events_text;
    TextView gallery_text ;
    TextView about_text;
    TextView coordination_text;
    TextView feedback_text;
    Vibrator vibrate;
    CardView contact;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        vibrate=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        // Initialize the TextView
        verticalsText = findViewById(R.id.verticals_text);
        events_text=findViewById(R.id.events_text);
        gallery_text=findViewById(R.id.gallery_text);
        about_text=findViewById(R.id.about_text);
        coordination_text=findViewById(R.id.coordination_text);
        feedback_text=findViewById(R.id.feedback_text);
        contact=findViewById(R.id.card_contact);

        // Set OnClickListener
        verticalsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, VerticalsActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        events_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, eventsActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        gallery_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, galleryActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        about_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, aboutActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        coordination_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, coordinationActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        feedback_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, feedbackActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, contactusActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

    }
}