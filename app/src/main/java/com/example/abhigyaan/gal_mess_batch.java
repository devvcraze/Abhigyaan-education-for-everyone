package com.example.abhigyaan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class gal_mess_batch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gal_mess_batch);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<ImageModel> imageList = new ArrayList<>();
        imageList.add(new ImageModel("https://drive.google.com/uc?export=view&id=1_xe0CvkWmoE2iOx3PtjW-XaErlUZSlXv"));
        imageList.add(new ImageModel("https://drive.google.com/uc?export=view&id=1mRRrXgExJG52_xarIQbRjyZTg0wdEJGZ"));
        imageList.add(new ImageModel("image1")); // Testing with another source

        // Add more image URLs

        ImageAdapter imageAdapter = new ImageAdapter(imageList);
        recyclerView.setAdapter(imageAdapter);
    }
}
