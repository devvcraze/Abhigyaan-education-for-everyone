package com.example.abhigyaan;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

public class MainAdapter_disha  extends FirebaseRecyclerAdapter<MainModel_disha,MainAdapter_disha.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter_disha(@NonNull FirebaseRecyclerOptions<MainModel_disha> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel_disha model) {
        holder.name.setText(model.getName());
        holder.clas.setText(model.getClas());
        holder.update.setText(model.getUpdate());
        Glide.with(holder.profile_image.getContext())
                .load(model.getSurl())
                .placeholder(R.drawable.ic_launcher_background)
                .circleCrop()
                .error(com.google.firebase.database.collection.R.drawable.googleg_standard_color_18)
                .into(holder.profile_image);

        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.profile_image.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();
                View view=dialogPlus.getHolderView();

                EditText name=(EditText)view.findViewById(R.id.textname);
                EditText clas=(EditText)view.findViewById(R.id.textclass);
                EditText update=(EditText)view.findViewById(R.id.textupdate);
                EditText image=(EditText)view.findViewById(R.id.imageurl);
                Button btnupdate=(Button)view.findViewById(R.id.updatedone);
                name.setText(model.getName());
                clas.setText(model.getClas());
                update.setText(model.getUpdate());
                image.setText(model.getSurl());
                dialogPlus.show();
                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("clas",clas.getText().toString());
                        map.put("update",update.getText().toString());
                        map.put("surl",image.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("UPdations_Disha")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), " Data Updated Succesfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.name.getContext(), " Error while updating data", Toast.LENGTH_SHORT).show();

                                    }
                                });


                    }
                });


            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView profile_image;
        Button btnedit,btndelete;
        TextView name,clas,update;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_image=(CircleImageView) itemView.findViewById(R.id.img1);
            name=(TextView) itemView.findViewById(R.id.nametxt);
            clas=(TextView)itemView.findViewById(R.id.classtext);
            update=(TextView)itemView.findViewById(R.id.updatetext);

            btnedit=(Button)itemView.findViewById(R.id.updatebtn);
        }
    }
}
