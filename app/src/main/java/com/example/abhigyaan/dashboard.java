package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

        // Initialize the TextView
        verticalsText = findViewById(R.id.verticals_text);
        events_text=findViewById(R.id.events_text);
        gallery_text=findViewById(R.id.gallery_text);
        about_text=findViewById(R.id.about_text);
        coordination_text=findViewById(R.id.coordination_text);
        feedback_text=findViewById(R.id.feedback_text);

        // Set OnClickListener
        verticalsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, VerticalsActivity.class);
                startActivity(intent);
            }
        });
        events_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, eventsActivity.class);
                startActivity(intent);
            }
        });
        gallery_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, galleryActivity.class);
                startActivity(intent);
            }
        });
        about_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, aboutActivity.class);
                startActivity(intent);
            }
        });
        coordination_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, coordinationActivity.class);
                startActivity(intent);
            }
        });
        feedback_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(dashboard.this, feedbackActivity.class);
                startActivity(intent);
            }
        });

    }
}