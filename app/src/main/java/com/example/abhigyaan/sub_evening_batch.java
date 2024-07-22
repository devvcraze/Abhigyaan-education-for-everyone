package com.example.abhigyaan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sub_evening_batch extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestAdapter requestAdapter;
    private List<Request> requestList;
    private Set<String> requestIds;
    private FloatingActionButton fab;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_evening_batch);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        requestList = new ArrayList<>();
        requestIds = new HashSet<>();
        requestAdapter = new RequestAdapter(this, requestList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(requestAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("requests");

        fab.setOnClickListener(view -> showAddRequestDialog());

        loadRequestsFromFirebase();
    }

    private void loadRequestsFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                requestList.clear();
                requestIds.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Request request = snapshot.getValue(Request.class);
                    if (request != null && !requestIds.contains(request.getId())) {
                        requestList.add(request);
                        requestIds.add(request.getId());
                    }
                }
                requestAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(sub_evening_batch.this, "Failed to load requests", Toast.LENGTH_SHORT).show();
            }
        });
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
                        Toast.makeText(sub_evening_batch.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
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
        Request request = new Request(id, name, whatsappNumber, dateTime, reason, false, null);
        if (id != null) {
            databaseReference.child(id).setValue(request).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    requestList.add(request);
                    requestAdapter.notifyDataSetChanged();
                    Toast.makeText(sub_evening_batch.this, "Request added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(sub_evening_batch.this, "Failed to add request", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
