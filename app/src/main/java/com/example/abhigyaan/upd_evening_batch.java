package com.example.abhigyaan;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class upd_evening_batch extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapter_evening mainAdapterDisha;
    ProgressBar progressBar;
    private DatabaseReference userRef;
    private FirebaseAuth mAuth;
    private boolean updateMade = false; // Flag to track if an update is made

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
                if (updateMade) {
                    incrementClassesTaken();
                }
            }
        };
        recyclerView.setAdapter(mainAdapterDisha);

        // Show the progress bar when data is being loaded
        progressBar.setVisibility(android.view.View.VISIBLE);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            userRef = FirebaseDatabase.getInstance().getReference().child("users").child(userId);
        }
    }

    private void incrementClassesTaken() {
        if (userRef != null) {
            userRef.child("classesTaken").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        int classesTaken = snapshot.getValue(Integer.class);
                        userRef.child("classesTaken").setValue(classesTaken + 1);
                    } else {
                        userRef.child("classesTaken").setValue(1);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle error if needed
                }
            });
            updateMade = false; // Reset the flag
        }
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
                if (updateMade) {
                    incrementClassesTaken();
                }
            }
        };
        mainAdapterDisha.startListening();
        recyclerView.setAdapter(mainAdapterDisha);

        // Show the progress bar when data is being loaded
        progressBar.setVisibility(android.view.View.VISIBLE);
    }

    // Call this method whenever an update is actually made
    public void setUpdateMade(boolean updateMade) {
        this.updateMade = updateMade;
    }
}
