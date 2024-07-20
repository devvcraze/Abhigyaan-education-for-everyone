package com.example.abhigyaan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class galleryActivity extends AppCompatActivity {

    private RecyclerView carouselRecyclerView;
    private ImageSliderAdapter imageSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);



        List<Integer> imageList = Arrays.asList(
                R.drawable.google,
                R.drawable.google,
                R.drawable.google,
                R.drawable.google
        );

        imageSliderAdapter = new ImageSliderAdapter(this, imageList);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

    }
}
