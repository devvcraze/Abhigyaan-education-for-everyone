package com.example.abhigyaan;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class galleryActivity extends AppCompatActivity {

    private static final String TAG = "galleryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<ImageModel> imageList = new ArrayList<>();
        ImageAdapter imageAdapter = new ImageAdapter(imageList);
        recyclerView.setAdapter(imageAdapter);

        // Fetch images from Firebase
        fetchImagesFromFirebase(imageList, imageAdapter);
    }

    private void fetchImagesFromFirebase(List<ImageModel> imageList, ImageAdapter imageAdapter) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("images");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                imageList.clear(); // Clear the list to avoid duplicates
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String imageUrl = snapshot.getValue(String.class);
                    imageList.add(new ImageModel(imageUrl));
                }
                imageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Failed to read image URLs from Firebase Database", databaseError.toException());
            }
        });
    }
}
