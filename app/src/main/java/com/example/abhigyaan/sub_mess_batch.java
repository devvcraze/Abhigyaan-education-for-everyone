package com.example.abhigyaan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sub_mess_batch extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestAdaptermes requestAdapter;
    private List<Request> requestList;
    private Set<String> requestIds;
    private FloatingActionButton fab;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_mess_batch);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        progressBar = findViewById(R.id.progressBar);
        requestList = new ArrayList<>();
        requestIds = new HashSet<>();
        requestAdapter = new RequestAdaptermes(this, requestList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(requestAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("requestsmes");

        fab.setOnClickListener(view -> showAddRequestDialog());

        loadRequestsFromFirebase();
    }

    private void loadRequestsFromFirebase() {
        progressBar.setVisibility(View.VISIBLE);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                progressBar.setVisibility(View.GONE);
                Request request = dataSnapshot.getValue(Request.class);
                if (request != null && !requestIds.contains(request.getId())) {
                    requestList.add(request);
                    requestIds.add(request.getId());
                    requestAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Request request = dataSnapshot.getValue(Request.class);
                if (request != null) {
                    int index = findRequestIndexById(request.getId());
                    if (index != -1) {
                        requestList.set(index, request);
                        requestAdapter.notifyItemChanged(index);
                    }
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Request request = dataSnapshot.getValue(Request.class);
                if (request != null) {
                    int index = findRequestIndexById(request.getId());
                    if (index != -1) {
                        requestList.remove(index);
                        requestIds.remove(request.getId());
                        requestAdapter.notifyItemRemoved(index);
                    }
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                // Not needed in this context
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(sub_mess_batch.this, "Failed to load requests", Toast.LENGTH_SHORT).show();
            }
        });

        // Hide progress bar after initial data load
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(sub_mess_batch.this, "Failed to load requests", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int findRequestIndexById(String id) {
        for (int i = 0; i < requestList.size(); i++) {
            if (requestList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private void showAddRequestDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_request, null);
        builder.setView(dialogView);

        final EditText editName = dialogView.findViewById(R.id.editName);
        final EditText editWhatsAppNumber = dialogView.findViewById(R.id.editWhatsAppNumber);
        final EditText editDateTime = dialogView.findViewById(R.id.editDateTime);
        final EditText editReason = dialogView.findViewById(R.id.editReason);

        builder.setTitle("Add Request")
                .setPositiveButton("Add", (dialog, which) -> {
                    String name = editName.getText().toString().trim();
                    String whatsappNumber = editWhatsAppNumber.getText().toString().trim();
                    String dateTime = editDateTime.getText().toString().trim();
                    String reason = editReason.getText().toString().trim();

                    if (name.isEmpty() || whatsappNumber.isEmpty() || dateTime.isEmpty() || reason.isEmpty()) {
                        Toast.makeText(sub_mess_batch.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    } else {
                        addRequest(name, whatsappNumber, dateTime, reason);
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void addRequest(String name, String whatsappNumber, String dateTime, String reason) {
        String id = databaseReference.push().getKey();
        if (id != null) {
            Request request = new Request(id, name, whatsappNumber, dateTime, reason, false, null);
            databaseReference.child(id).setValue(request).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(sub_mess_batch.this, "Request added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(sub_mess_batch.this, "Failed to add request", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
