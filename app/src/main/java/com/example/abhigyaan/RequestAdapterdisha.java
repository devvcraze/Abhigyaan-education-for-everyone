package com.example.abhigyaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RequestAdapterdisha extends RecyclerView.Adapter<RequestAdapterdisha.RequestViewHolder> {

    private Context context;
    private List<Request> requestList;

    public RequestAdapterdisha(Context context, List<Request> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @Override
    public RequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.request_item, parent, false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RequestViewHolder holder, int position) {
        Request request = requestList.get(position);
        holder.nameTextView.setText(request.getName());
        holder.whatsappNumberTextView.setText(request.getWhatsAppNumber());
        holder.dateTimeTextView.setText(request.getDateTime());
        holder.reasonTextView.setText(request.getReason());
        holder.acceptedCheckBox.setChecked(request.isAccepted());

        if (request.isAccepted() && request.getAcceptedBy() != null) {
            holder.acceptedByTextView.setText("Accepted by: " + request.getAcceptedBy());
            holder.acceptedByTextView.setVisibility(View.VISIBLE);
        } else {
            holder.acceptedByTextView.setVisibility(View.GONE);
        }

        holder.acceptedCheckBox.setOnClickListener(v -> {
            if (holder.acceptedCheckBox.isChecked()) {
                showNameInputDialog(request, holder.acceptedByTextView);
            } else {
                updateRequestAcceptance(request, false, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    private void showNameInputDialog(Request request, TextView acceptedByTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_input_name, null);
        builder.setView(dialogView);

        final EditText editName = dialogView.findViewById(R.id.editName);

        builder.setTitle("Enter your name")
                .setPositiveButton("OK", (dialog, which) -> {
                    String name = editName.getText().toString().trim();
                    if (!name.isEmpty()) {
                        updateRequestAcceptance(request, true, name);
                        acceptedByTextView.setText("Accepted by: " + name);
                        acceptedByTextView.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(context, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void updateRequestAcceptance(Request request, boolean isAccepted, String acceptedBy) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("requestsdis").child(request.getId());
        request.setAccepted(isAccepted);
        request.setAcceptedBy(acceptedBy);
        databaseReference.setValue(request).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                notifyDataSetChanged();
                Toast.makeText(context, "Request updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Failed to update request", Toast.LENGTH_SHORT).show();
            }
        });
    }

    static class RequestViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, whatsappNumberTextView, dateTimeTextView, reasonTextView, acceptedByTextView;
        CheckBox acceptedCheckBox;

        public RequestViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            whatsappNumberTextView = itemView.findViewById(R.id.whatsappNumberTextView);
            dateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
            reasonTextView = itemView.findViewById(R.id.reasonTextView);
            acceptedByTextView = itemView.findViewById(R.id.acceptedByTextView);
            acceptedCheckBox = itemView.findViewById(R.id.acceptedCheckBox);
        }
    }
}
