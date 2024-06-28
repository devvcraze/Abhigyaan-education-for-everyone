package com.example.abhigyaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button callSign, mainsubmit;
    ImageView imageView;
    TextView welcome, signup3;
    TextInputLayout usernamemain, password_togglemain;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callSign = findViewById(R.id.signup);
        usernamemain = findViewById(R.id.usernamemain);
        password_togglemain = findViewById(R.id.password_togglemain);

        callSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SIGNUP.class);
                startActivity(intent);
            }
        });
    }

    private Boolean validatePassword() {
        String val = password_togglemain.getEditText().getText().toString();
        if (val.isEmpty()) {
            password_togglemain.setError("Field cannot be empty");
            return false;
        } else {
            password_togglemain.setError(null);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = usernamemain.getEditText().getText().toString();
        if (val.isEmpty()) {
            usernamemain.setError("Field cannot be empty");
            return false;
        } else {
            usernamemain.setError(null);
            usernamemain.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {
        if (!validateUsername() || !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        final String usernameentered = usernamemain.getEditText().getText().toString().trim();
        final String passwordentered = password_togglemain.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(usernameentered);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    usernamemain.setError(null);
                    String Passwordfromdb = snapshot.child(usernameentered).child("password").getValue(String.class);
                    if (passwordentered.equals(Passwordfromdb)) {
                        String namefromdb = snapshot.child(usernameentered).child("name").getValue(String.class);
                        String usernamefromdb = snapshot.child(usernameentered).child("username").getValue(String.class);
                        String phonefromdb = snapshot.child(usernameentered).child("phone").getValue(String.class);
                        String email1fromdb = snapshot.child(usernameentered).child("email").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), userprofile.class);
                        intent.putExtra("name", namefromdb);
                        intent.putExtra("username", usernamefromdb);
                        intent.putExtra("phone", phonefromdb);
                        intent.putExtra("email", email1fromdb);
                        intent.putExtra("password", Passwordfromdb);
                        startActivity(intent);
                    } else {
                        password_togglemain.setError("Wrong password");
                        password_togglemain.requestFocus();
                    }
                } else {
                    usernamemain.setError("User does not exist");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
