package com.example.abhigyaan;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder> {

    private final Context context;
    private final List<Request> requestList;
    private final DatabaseReference databaseReference;

    public RequestAdapter(Context context, List<Request> requestList) {
        this.context = context;
        this.requestList = requestList;
        this.databaseReference = FirebaseDatabase.getInstance().getReference("requests");
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.request_item, parent, false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
        Request request = requestList.get(position);

        holder.nameTextView.setText("Name: " + request.getName());
        holder.whatsappNumberTextView.setText("WhatsApp Number: " + request.getWhatsappNumber());
        holder.dateTimeTextView.setText("Date and Time: " + request.getDateTime());
        holder.reasonTextView.setText("Reason: " + request.getReason());

        if (request.isAccepted()) {
            holder.acceptedByTextView.setText("Accepted by: " + request.getAcceptedBy());
            holder.acceptCheckBox.setChecked(true);
        } else {
            holder.acceptedByTextView.setText("");
            holder.acceptCheckBox.setChecked(false);
        }

        holder.acceptCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                showNameInputDialog(request);
            } else {
                holder.acceptedByTextView.setText("");
                request.setAccepted(false);
                request.setAcceptedBy(null);
                updateRequestInFirebase(request);
            }
        });
    }

    private void showNameInputDialog(Request request) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_input_name, null);
        builder.setView(dialogView);

        final EditText editName = dialogView.findViewById(R.id.editName);
        builder.setTitle("Enter Your Name")
                .setPositiveButton("Submit", (dialog, which) -> {
                    String name = editName.getText().toString().trim();
                    if (!name.isEmpty()) {
                        request.setAccepted(true);
                        request.setAcceptedBy(name);
                        updateRequestInFirebase(request);
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    ((CheckBox) ((AlertDialog) dialog).findViewById(R.id.acceptCheckBox)).setChecked(false);
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void updateRequestInFirebase(Request request) {
        if (request.getId() != null) {
            databaseReference.child(request.getId()).setValue(request);
        }
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    static class RequestViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView whatsappNumberTextView;
        TextView dateTimeTextView;
        TextView reasonTextView;
        TextView acceptedByTextView;
        CheckBox acceptCheckBox;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            whatsappNumberTextView = itemView.findViewById(R.id.whatsappNumberTextView);
            dateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
            reasonTextView = itemView.findViewById(R.id.reasonTextView);
            acceptedByTextView = itemView.findViewById(R.id.acceptedByTextView);
            acceptCheckBox = itemView.findViewById(R.id.acceptCheckBox);
        }
    }
}
