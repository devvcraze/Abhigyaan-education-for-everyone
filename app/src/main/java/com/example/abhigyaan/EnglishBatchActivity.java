package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EnglishBatchActivity extends AppCompatActivity {
    Vibrator vibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        vibrate=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        setContentView(R.layout.activity_english_batch);
        CardView cardView = findViewById(R.id.volun_english);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnglishBatchActivity.this,  volunteer_english_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView2 = findViewById(R.id.update_english);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnglishBatchActivity.this,  update_english_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView3 = findViewById(R.id.material_english);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnglishBatchActivity.this,  material_english_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView4 = findViewById(R.id.sub_eng);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnglishBatchActivity.this,  sub_english_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView5 = findViewById(R.id.mem_eng);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnglishBatchActivity.this,  mem_english_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView6 = findViewById(R.id.gal_eng);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnglishBatchActivity.this,  gal_english_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}