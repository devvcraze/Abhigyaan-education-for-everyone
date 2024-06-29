package com.example.abhigyaan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SIGNUP extends AppCompatActivity {
    Button submit, already_account;
    TextInputLayout name, username, email, phone, password_toggle;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private Boolean validateName() {
        String val = name.getEditText().getText().toString();
        if (val.isEmpty()) {
            name.setError("Field cannot be empty");
            return false;
        } else {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            username.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            username.setError("Whitespaces are not allowed");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private Boolean validatePhoneNo() {
        String val = phone.getEditText().getText().toString();
        if (val.isEmpty()) {
            phone.setError("Field cannot be empty");
            return false;
        } else {
            phone.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password_toggle.getEditText().getText().toString();
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        if (val.isEmpty()) {
            password_toggle.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordPattern)) {
            password_toggle.setError("Password is too weak");
            return false;
        } else {
            password_toggle.setError(null);
            password_toggle.setErrorEnabled(false);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        password_toggle = findViewById(R.id.password_toggle);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        submit = findViewById(R.id.submit);
        already_account = findViewById(R.id.already_account);
        name = findViewById(R.id.name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName() | !validateUsername() | !validateEmail() | !validatePhoneNo() | !validatePassword()) {
                    return;
                }
                String name1 = Objects.requireNonNull(name.getEditText()).getText().toString();
                String phone1 = Objects.requireNonNull(phone.getEditText()).getText().toString();
                String email1 = Objects.requireNonNull(email.getEditText()).getText().toString();
                String username1 = Objects.requireNonNull(username.getEditText()).getText().toString();
                String password = Objects.requireNonNull(password_toggle.getEditText()).getText().toString();

                if (!name1.isEmpty() && !phone1.isEmpty() && !email1.isEmpty() && !username1.isEmpty() && !password.isEmpty()) {
                    helperclass user = new helperclass(name1, username1, email1, phone1, password);
                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("Users");
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
