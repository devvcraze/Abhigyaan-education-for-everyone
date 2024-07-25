package com.example.abhigyaan;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class upd_evening_batch extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapter_evening mainAdapterDisha;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd_evening_batch);

        recyclerView = findViewById(R.id.rv);
        progressBar = findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel_disha> options =
                new FirebaseRecyclerOptions.Builder<MainModel_disha>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("UPdations_evening"), MainModel_disha.class)
                        .build();

        mainAdapterDisha = new MainAdapter_evening(options) {
            @Override
            public void onDataChanged() {
                super.onDataChanged();
                // Hide the progress bar when data is loaded
                progressBar.setVisibility(android.view.View.GONE);
            }
        };
        recyclerView.setAdapter(mainAdapterDisha);

        // Show the progress bar when data is being loaded
        progressBar.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapterDisha.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapterDisha.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str) {
        FirebaseRecyclerOptions<MainModel_disha> options =
                new FirebaseRecyclerOptions.Builder<MainModel_disha>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("UPdations_evening").orderByChild("name").startAt(str).endAt(str + "\uf8ff"), MainModel_disha.class)
                        .build();
        mainAdapterDisha = new MainAdapter_evening(options) {
            @Override
            public void onDataChanged() {
                super.onDataChanged();
                // Hide the progress bar when data is loaded
                progressBar.setVisibility(android.view.View.GONE);
            }
        };
        mainAdapterDisha.startListening();
        recyclerView.setAdapter(mainAdapterDisha);

        // Show the progress bar when data is being loaded
        progressBar.setVisibility(android.view.View.VISIBLE);
    }
}
