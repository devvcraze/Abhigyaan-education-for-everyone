package com.example.abhigyaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mat_lamani_batch extends AppCompatActivity {
    CardView worsheet,books,pyq,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mat_lamani_batch);
        worsheet=findViewById(R.id.tutorials);
        books=findViewById(R.id.Books);
        pyq=findViewById(R.id.Past);
        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://chat.whatsapp.com/HVb3aSWkrFX8EycsV4JPs5");

            }
        });
        worsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://drive.google.com/drive/folders/1MbXSRuc-inUs1AzudSHUH3zhCIJbBxcg?usp=sharing");

            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://drive.google.com/drive/folders/15d2Yapqxt5V1jFvEXuV5-HaMMwkXe3XW?usp=sharing");

            }
        });
        pyq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://drive.google.com/drive/folders/1glmONLMfLBOwZ0zmUZRiC891HfnEnuBz?usp=sharing");

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void gotourl(String url) {
        try {
            Uri uri = Uri.parse(url);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (Exception e) {
            Toast.makeText(this, "Nothing here", Toast.LENGTH_SHORT).show();
        }
    }
}