package com.example.abhigyaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class eventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_events);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        Button skipButton = findViewById(R.id.skipButton);

        skipButton.setOnClickListener(v -> {
            // Launch new activity when skip button is clicked
            Intent intent = new Intent(eventsActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        List<OnboardingItem> onboardingItems = new ArrayList<>();
        onboardingItems.add(new OnboardingItem(R.drawable.independece, "Title 1", "Description 1"));
        onboardingItems.add(new OnboardingItem(R.drawable.children, "Title 2", "Description 2"));
        onboardingItems.add(new OnboardingItem(R.drawable.work, "Title 3", "Description 3"));
        onboardingItems.add(new OnboardingItem(R.drawable.donate, "Title 4", "Description 4"));
        onboardingItems.add(new OnboardingItem(R.drawable.envi1, "Title 5", "Description 5"));
        onboardingItems.add(new OnboardingItem(R.drawable.envi2, "Title 6", "Description 6"));

        OnboardingAdapter onboardingAdapter = new OnboardingAdapter(onboardingItems);
        viewPager.setAdapter(onboardingAdapter);

        // Set the custom fade page transformer
        viewPager.setPageTransformer(new CustomFadePageTransformer());

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(String.valueOf(position + 1))
        ).attach();
    }
}
