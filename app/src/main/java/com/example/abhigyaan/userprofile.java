package com.example.abhigyaan;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

/*public class userprofile extends AppCompatActivity {
    TextInputLayout fullname,email,phone,password;
    TextView fullname_lable1,fullname_lable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_userprofile);
        fullname=findViewById(R.id.full_name_profile);
        email=findViewById(R.id.email_profile);
        phone=findViewById(R.id.phone_profile);
        password=findViewById(R.id.pasword_profile);
        fullname_lable1=findViewById(R.id.full_name_profile_label);
        fullname_lable2=findViewById(R.id.full_name_profile_label2);
        showAllUserData();

        LinearLayout linearLayout = findViewById(R.id.main); // Ensure you have the correct ID
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void showAllUserData() {
        Intent intent=getIntent();

    }
}*/