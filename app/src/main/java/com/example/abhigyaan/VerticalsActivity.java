// VerticalsActivity.java
package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VerticalsActivity extends AppCompatActivity {
    Vibrator vibrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verticals);
        vibrate=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        // Find the TextViews by their IDs
        TextView eveningBatchTextView = findViewById(R.id.evening_batch);
        TextView projectDishaTextView = findViewById(R.id.project_disha);
        TextView messBatchTextView = findViewById(R.id.mess_batch);
        TextView projectLamaniTextView = findViewById(R.id.project_lamani);
        TextView englishBatchTextView = findViewById(R.id.english_batch);
        TextView aboutVerticalsTextView = findViewById(R.id.about_verticals);

        // Set OnClickListeners for each TextView
        eveningBatchTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Navigate to evening_batch activity
               Intent intent = new Intent(VerticalsActivity.this, EveningBatchActivity.class);
               vibrate.vibrate(100);
               startActivity(intent);
            }
        });

        projectDishaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to project_disha activity
                Intent intent = new Intent(VerticalsActivity.this, ProjectDishaActivity.class);
                vibrate.vibrate(100);
               startActivity(intent);
            }
        });

        messBatchTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to mess_batch activity
               Intent intent = new Intent(VerticalsActivity.this, MessBatchActivity.class);
                vibrate.vibrate(100);
               startActivity(intent);
            }
        });

        projectLamaniTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to project_lamani activity
                Intent intent = new Intent(VerticalsActivity.this, ProjectLamaniActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        englishBatchTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to english_batch activity
                Intent intent = new Intent(VerticalsActivity.this, EnglishBatchActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });

        aboutVerticalsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to about_verticals activity
               Intent intent = new Intent(VerticalsActivity.this, AboutVerticalsActivity.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
    }
}
