package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MessBatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mess_batch);
        CardView cardView = findViewById(R.id.vol_mes);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessBatchActivity.this,  vol_mess_batch.class);
                startActivity(intent);
            }
        });
        CardView cardView2 = findViewById(R.id.sub_mes);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessBatchActivity.this,  sub_mess_batch.class);
                startActivity(intent);
            }
        });
        CardView cardView3 = findViewById(R.id.upd_mes);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessBatchActivity.this,  upd_mess_batch.class);
                startActivity(intent);
            }
        });
        CardView cardView4 = findViewById(R.id.mat_mes);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessBatchActivity.this,  mat_mess_batch.class);
                startActivity(intent);
            }
        });
        CardView cardView5 = findViewById(R.id.gal_mes);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessBatchActivity.this,  gal_mess_batch.class);
                startActivity(intent);
            }
        });
        CardView cardView6 = findViewById(R.id.mem_mes);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessBatchActivity.this,  mem_mess_batch.class);
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