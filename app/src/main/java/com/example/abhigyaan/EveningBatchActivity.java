package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.abhigyaan.fragment.Fragment_eve_material;
import com.example.abhigyaan.fragment.Fragment_eve_member;
import com.example.abhigyaan.fragment.Fragment_eve_update;
import com.example.abhigyaan.fragment.Fragment_eve_vol;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class EveningBatchActivity extends AppCompatActivity {
    Vibrator vibrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vibrate=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_evening_batch);
        CardView cardView = findViewById(R.id.vol_eve);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EveningBatchActivity.this,  vol_evening_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView2 = findViewById(R.id.upd_eve);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EveningBatchActivity.this,  upd_evening_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView3 = findViewById(R.id.mat_eve);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EveningBatchActivity.this,  mat_evening_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView4 = findViewById(R.id.sub_eve);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EveningBatchActivity.this,  sub_evening_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView5 = findViewById(R.id.mem_eve);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EveningBatchActivity.this,  mem_evening_batch.class);
                vibrate.vibrate(100);
                startActivity(intent);
            }
        });
        CardView cardView6 = findViewById(R.id.gal_eve);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EveningBatchActivity.this,  gal_evening_batch.class);
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
