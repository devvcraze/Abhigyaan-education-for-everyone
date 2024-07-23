package com.example.abhigyaan;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter_disha extends FirebaseRecyclerAdapter<MainModel_disha, MainAdapter_disha.myViewHolder> {

    private upd_evening_batch activity;

    public MainAdapter_disha(@NonNull FirebaseRecyclerOptions<MainModel_disha> options, upd_evening_batch activity) {
        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel_disha model) {
        holder.name.setText(model.getName());
        holder.clas.setText(model.getClas());
        holder.update.setText(model.getUpdate());
        Glide.with(holder.profile_image.getContext())
                .load(model.getSurl())
                .placeholder(R.drawable.abhigyaan_logo)
                .circleCrop();

        holder.itemView.setOnClickListener(v -> {
            // Notify activity that an update is being made
            activity.setUpdateMade(true);

            // Show update dialog
            showUpdateDialog(model.getUpdate());
        });
    }

    private void showUpdateDialog(String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.update_popup, null);
        builder.setView(dialogView);

        EditText nameEditText = dialogView.findViewById(R.id.textname);
        EditText clasEditText = dialogView.findViewById(R.id.textclass);
        EditText updateEditText = dialogView.findViewById(R.id.textupdate);
        Button updateButton = dialogView.findViewById(R.id.imageurl);

        builder.setTitle("Update Record");
        AlertDialog dialog = builder.create();
        dialog.show();

        updateButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String clas = clasEditText.getText().toString();
            String update = updateEditText.getText().toString();

            Map<String, Object> updates = new HashMap<>();
            updates.put("name", name);
            updates.put("clas", clas);
            updates.put("update", update);

            FirebaseDatabase.getInstance().getReference()
                    .child("UPdations_evening")
                    .child(id)
                    .updateChildren(updates)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(activity, "Record Updated", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(activity, "Update Failed", Toast.LENGTH_SHORT).show();
                    });
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.update_popup, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profile_image;
        TextView name, clas, update;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.nametxt);
            clas = itemView.findViewById(R.id.classtext);
            update = itemView.findViewById(R.id.updatetext);
        }
    }
}
