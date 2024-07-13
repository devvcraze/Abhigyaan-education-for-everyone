package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProjectDishaActivity extends AppCompatActivity {
    CardView mat,vol,sub,mem,gal,upd;
    Vibrator vibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project_disha);
        mat=findViewById(R.id.mat_disha);
        sub=findViewById(R.id.sub_disha);
        vol=findViewById(R.id.vol_disha);
        gal=findViewById(R.id.gal_disha);
        mem=findViewById(R.id.mem_disha);
        upd=findViewById(R.id.upd_disha);
        vibrate=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        mat.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectDishaActivity.this,  mat_disha_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        vol.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectDishaActivity.this,  vol_disha_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);

        });
        gal.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectDishaActivity.this,  gal_disha_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        mem.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectDishaActivity.this,  mem_disha_batch.class);
            vibrate.vibrate(100);
            startActivity(intent);
        });
        upd.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectDishaActivity.this,  upd_disha_batch.class);
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