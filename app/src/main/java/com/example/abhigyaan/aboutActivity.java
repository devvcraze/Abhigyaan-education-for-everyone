package com.example.abhigyaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openInstagram(View view) {
        openUrl("https://www.instagram.com/abhigyaan_bitsgoa?igsh=cmxlbzk2ZDd6YjQ5");
    }

    public void openLinkedIn(View view) {
        openUrl("https://www.linkedin.com/company/abhigyaan/mycompany/");
    }

    public void openFacebook(View view) {
        openUrl("https://www.facebook.com/abhigyaanbpgc/");
    }

    public void openWebsite(View view) {
        openUrl("https://www.yourwebsite.com");
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}