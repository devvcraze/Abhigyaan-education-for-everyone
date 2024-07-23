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

public class ProjectLamaniActivity extends AppCompatActivity {
    CardView mat,vol,sub,mem,gal,upd;
    Vibrator vibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vibrate=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project_lamani);
        mat=findViewById(R.id.mat_lamani);
        sub=findViewById(R.id.sub_lamani);
        vol=findViewById(R.id.vol_lamani);
        gal=findViewById(R.id.gal_lamani);
        mem=findViewById(R.id.mem_lamani);
        upd=findViewById(R.id.upd_lamani);
        sub.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectLamaniActivity.this,  sub_lamani_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        mat.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectLamaniActivity.this,  mat_lamani_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        vol.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectLamaniActivity.this,  vol_lamani_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        gal.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectLamaniActivity.this,  gal_lamani_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        mem.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectLamaniActivity.this,  mem_lamani_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        upd.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectLamaniActivity.this,  upd_lamani_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}