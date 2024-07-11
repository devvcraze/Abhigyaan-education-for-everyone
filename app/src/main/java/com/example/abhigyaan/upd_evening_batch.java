package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class upd_evening_batch extends AppCompatActivity {
    FloatingActionButton addNoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd_evening_batch); // setContentView should be called before findViewById
        addNoteBtn = findViewById(R.id.add_note_btn);
        EdgeToEdge.enable(this);
        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(upd_evening_batch.this, evenotedetails.class);
                startActivity(intent);
            }
        });
    }
}
