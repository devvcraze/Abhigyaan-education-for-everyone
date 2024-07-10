package com.example.abhigyaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mat_evening_batch extends AppCompatActivity {
    CardView worsheet,books,pyq,add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mat_evening_batch);
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
                gotourl("https://drive.google.com/drive/folders/1-bR4f7_5Tqo7SC0ElpKasj4fU3syJ9R7?usp=sharing");

            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://drive.google.com/drive/folders/1lzlT01F-YdY6YnOLupmwEqvVcdOCfpAa?usp=sharing");

            }
        });
        pyq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://drive.google.com/drive/folders/1EwYyR8JZqUICpb5O0tmycXG03DY6FaM0?usp=sharing");

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