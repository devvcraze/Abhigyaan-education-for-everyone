package com.example.abhigyaan;

import android.os.Bundle;

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

public class AboutVerticalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_verticals);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);


        List<OnboardingItem> onboardingItems = new ArrayList<>();
        onboardingItems.add(new OnboardingItem(R.drawable.evening4, "Evening Batch", "The Evening Batch is a targeted initiative designed to support the educational needs of our non-teaching staff's children. Conducted on campus in designated classrooms, this program offers flexible learning opportunities with two time slots: 5:30-6:30 PM and 6:30-7:30 PM. Our volunteer educators work diligently to align their teaching with the students' current academic curricula, ensuring seamless integration with their school studies. This program not only enhances the students' academic performance but also fosters a sense of community within our campus. The Evening Batch reflects our commitment to inclusive education and support for our extended campus family"));
        onboardingItems.add(new OnboardingItem(R.drawable.anubhav3, "Project Disha", "Project Disha stands as our specialized program aimed at preparing students from classes 5 and 8 for the prestigious Jawahar Navodaya Vidyalaya (JNV) Selection Test. Our dedicated team utilizes carefully curated materials from our extensive Disha Drive to ensure comprehensive test preparation. The program's efficacy is evident in our consistent success rate, with an average of 3-6 students selected annually for JNV. This achievement not only validates our methodologies but also significantly impacts the educational trajectories of these young learners. Project Disha exemplifies our commitment to opening doors to quality education and brighter futures for deserving students."));
        onboardingItems.add(new OnboardingItem(R.drawable.lamani, "Project Lamani", "Project Lamani is our flagship initiative dedicated to empowering underprivileged children in the Lamani slum. Our committed volunteers provide comprehensive education to students from classes 1-4, 6-7, and 9-12, following their school curricula. We employ tailored teaching methodologies designed to accelerate learning and foster intellectual curiosity. Our approach is holistic, focusing not only on academic growth but also on personal development. Utilizing advanced progress tracking tools, we monitor each student's journey, allowing us to adapt our methods to individual needs. Project Lamani exemplifies our commitment to bridging educational gaps and creating opportunities for those who need them most.\n" +
                "\n"));
        onboardingItems.add(new OnboardingItem(R.drawable.mess, "Mess Batch", "The Mess Batch is an innovative late-night education program specifically designed for our mess workers. Running from 10:00-11:00 PM, this course focuses on developing essential computer skills, proficiency in office applications, and building overall confidence for career advancement. Our curriculum is tailored to meet the unique scheduling needs of mess staff while providing them with valuable technological competencies. The program's success is evident in the number of participants who have secured improved positions, including non-teaching staff and hostel assistant roles. The Mess Batch demonstrates our commitment to empowering all members of our campus community with skills for the modern workplace."));
        onboardingItems.add(new OnboardingItem(R.drawable.english, "English Batch", "The English Batch is a specialized program tailored for our housekeeping staff, focusing on practical English communication skills and essential mathematical concepts. Conducted from 5:00-6:00 PM, this course emphasizes real-world applications of language and numeracy. Our curriculum is designed to enhance workplace communication, boost confidence in daily interactions, and improve basic financial literacy. By empowering our staff with these crucial skills, we aim to enhance both their professional capabilities and personal development. The English Batch exemplifies our dedication to continuous learning and the holistic growth of our entire campus communit"));


        OnboardingAdapter onboardingAdapter = new OnboardingAdapter(onboardingItems);
        viewPager.setAdapter(onboardingAdapter);

        // Set the custom fade page transformer
        viewPager.setPageTransformer(new CustomFadePageTransformer());

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(String.valueOf(position + 1))
        ).attach();
    }
}
