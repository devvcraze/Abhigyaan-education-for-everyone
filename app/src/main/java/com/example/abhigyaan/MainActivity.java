package com.example.abhigyaan;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    Animation top_anim;
    ImageView image;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        image = findViewById(R.id.imageView);
        image.setAnimation(top_anim);

        // Check if the user is already signed in
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            // User is signed in, navigate to the dashboard
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(MainActivity.this, dashboard.class);
                startActivity(intent);
                finish();
            }, SPLASH_SCREEN);
        } else {
            // User is not signed in, navigate to the login activity
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(MainActivity.this, Login.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());
                finish();
            }, SPLASH_SCREEN);
        }
    }
}
