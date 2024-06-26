package com.example.abhigyaan;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Firebase;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import java.util.Objects;

public class SIGNUP extends AppCompatActivity {
    Button submit,already_account;
    TextInputLayout name,username,email,phone,password_toggle;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        password_toggle=findViewById(R.id.password_toggle);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        submit=findViewById(R.id.submit);
        already_account=findViewById(R.id.already_account);
        name=findViewById(R.id.name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = Objects.requireNonNull(name.getEditText()).getText().toString();
                String phone1 = Objects.requireNonNull(phone.getEditText()).getText().toString();
                String email1 = Objects.requireNonNull(email.getEditText()).getText().toString();
                String username1 = Objects.requireNonNull(username.getEditText()).getText().toString();
                String password = Objects.requireNonNull(password_toggle.getEditText()).getText().toString();

                if (!name1.isEmpty() && !phone1.isEmpty() && !email1.isEmpty() && !username1.isEmpty() && !password.isEmpty()) {
                    helperclass user = new helperclass(name1, phone1, email1, username1, password);
                    rootNode = FirebaseDatabase.getInstance();
                    reference=rootNode.getReference("Users");
                    reference.child(username1).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // Clear the input fields after successful registration
                                name.getEditText().setText("");
                                phone.getEditText().setText("");
                                email.getEditText().setText("");
                                username.getEditText().setText("");
                                password_toggle.getEditText().setText("");
                            }
                        }
                    });
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}