package com.example.abhigyaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class aboutActivity extends AppCompatActivity {
    TextView text1,text2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
      text1=findViewById(R.id.contactContentTextView3);
      text2=findViewById(R.id.contactContentTextView);
      text1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(aboutActivity.this,  feedbackActivity.class);

              startActivity(intent);
          }
      });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aboutActivity.this,  contactusActivity.class);

                startActivity(intent);
            }
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

    public void openlinktree(View view) {
        openUrl("https://linktr.ee/abhigyaan");
    }

    public void openyoutube(View view) {
        openUrl("https://www.youtube.com/channel/your_channel");
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}
