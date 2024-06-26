package com.example.abhigyaan;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class Login extends AppCompatActivity {
    Button callSign,submit,already_account;
    ImageView imageView;
    TextView welcome,signup3;
    TextInputLayout name,username,email,phone,password_toggle;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_login);
        findViewById(R.id.textInputLayoutPassword);
        callSign=findViewById(R.id.signup);
        imageView=findViewById(R.id.imageView);
        welcome=findViewById(R.id.welcome);
        signup3=findViewById(R.id.signup3);
        password_toggle=findViewById(R.id.password_toggle);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        submit=findViewById(R.id.submit);
        already_account=findViewById(R.id.already_account);
        name=findViewById(R.id.name);


        callSign.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, SIGNUP.class);
            startActivity(intent);

        });
    }
}