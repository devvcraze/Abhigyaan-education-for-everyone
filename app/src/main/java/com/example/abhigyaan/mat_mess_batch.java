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

public class mat_mess_batch extends AppCompatActivity {
    CardView worsheet,books,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mat_mess_batch);
        worsheet=findViewById(R.id.tutorials);
        books=findViewById(R.id.Books);
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
                gotourl("https://drive.google.com/drive/folders/1UT6gEnxx59w1z0NSz2MNU464DmXKYzlw?usp=sharing");

            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://drive.google.com/drive/folders/1S91_s0mX3WPA4cXmS7G0vosu7TRhSwN7?usp=sharing");

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