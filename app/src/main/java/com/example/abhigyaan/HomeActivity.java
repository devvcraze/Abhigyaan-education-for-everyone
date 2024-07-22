package com.example.abhigyaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private CardView cardUpcoming;
    private CardView cardPast;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        cardUpcoming = findViewById(R.id.card_events);
        cardPast = findViewById(R.id.upcoming_events);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set OnClickListener for the Upcoming events CardView
        cardUpcoming.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, UpcomingEventsActivity.class);
            startActivity(intent);
        });

        // Set OnClickListener for the Past events CardView
        cardPast.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PastEventsActivity.class);
            startActivity(intent);
        });
    }
}
