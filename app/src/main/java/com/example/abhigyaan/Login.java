package com.example.abhigyaan;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    Button callSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_login);
        findViewById(R.id.textInputLayoutPassword);
        callSign=findViewById(R.id.signup);
        callSign.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, SIGNUP.class);
            startActivity(intent);

        });
    }
}