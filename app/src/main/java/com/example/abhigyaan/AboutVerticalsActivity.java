package com.example.abhigyaan;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AboutVerticalsActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_verticals);

        viewFlipper = findViewById(R.id.viewFlipper);
        LayoutInflater inflater = LayoutInflater.from(this);

        // Data arrays for titles, contents, and image resources
        String[] titles = {"Evening Batch", "Mess Batch", "Project Disha", "English Batch", "Project Lamani"};
        String[] contents = {
                "The Evening Batch is a targeted initiative designed to support the educational needs of our non-teaching staff's children. Conducted on campus in designated classrooms, this program offers flexible learning opportunities with two time slots: 5:30-6:30 PM and 6:30-7:30 PM. Our volunteer educators work diligently to align their teaching with the students' current academic curricula, ensuring seamless integration with their school studies. This program not only enhances the students' academic performance but also fosters a sense of community within our campus. The Evening Batch reflects our commitment to inclusive education and support for our extended campus family.",
                "The Mess Batch is an innovative late-night education program specifically designed for our mess workers. Running from 10:00-11:00 PM, this course focuses on developing essential computer skills, proficiency in office applications, and building overall confidence for career advancement. Our curriculum is tailored to meet the unique scheduling needs of mess staff while providing them with valuable technological competencies. The program's success is evident in the number of participants who have secured improved positions, including non-teaching staff and hostel assistant roles. The Mess Batch demonstrates our commitment to empowering all members of our campus community with skills for the modern workplace.",
                "Project Disha stands as our specialized program aimed at preparing students from classes 5 and 8 for the prestigious Jawahar Navodaya Vidyalaya (JNV) Selection Test. Our dedicated team utilizes carefully curated materials from our extensive Disha Drive to ensure comprehensive test preparation. The program's efficacy is evident in our consistent success rate, with an average of 3-6 students selected annually for JNV. This achievement not only validates our methodologies but also significantly impacts the educational trajectories of these young learners. Project Disha exemplifies our commitment to opening doors to quality education and brighter futures for deserving students.",
                "The English Batch is a specialized program tailored for our housekeeping staff, focusing on practical English communication skills and essential mathematical concepts. Conducted from 5:00-6:00 PM, this course emphasizes real-world applications of language and numeracy. Our curriculum is designed to enhance workplace communication, boost confidence in daily interactions, and improve basic financial literacy. By empowering our staff with these crucial skills, we aim to enhance both their professional capabilities and personal development. The English Batch exemplifies our dedication to continuous learning and the holistic growth of our entire campus community",
                "Project Lamani is our flagship initiative dedicated to empowering underprivileged children in the Lamani slum. Our committed volunteers provide comprehensive education to students from classes 1-4, 6-7, and 9-12, following their school curricula. We employ tailored teaching methodologies designed to accelerate learning and foster intellectual curiosity. Our approach is holistic, focusing not only on academic growth but also on personal development. Utilizing advanced progress tracking tools, we monitor each student's journey, allowing us to adapt our methods to individual needs. Project Lamani exemplifies our commitment to bridging educational gaps and creating opportunities for those who need them most."
        };
        int[] imageResources = {
                R.drawable.evening, // Replace with your actual image resources
                R.drawable.mess,
                R.drawable.anubhav3,
                R.drawable.english,
                R.drawable.lamani
        };

        // Add 5 CardViews to the ViewFlipper
        for (int i = 0; i < 5; i++) {
            // Inflate the card view layout
            CardView cardView = (CardView) inflater.inflate(R.layout.card_view_layout, null);

            // Set the image, title, and content of the card view
            ImageView cardImage = cardView.findViewById(R.id.cardImage);
            TextView cardTitle = cardView.findViewById(R.id.cardTitle);
            TextView cardContent = cardView.findViewById(R.id.cardContent);

            // Set image resource, title, and content
            cardImage.setImageResource(imageResources[i]);
            cardTitle.setText(titles[i]);
            cardContent.setText(contents[i]);

            // Add the card view to the view flipper
            viewFlipper.addView(cardView);
        }

        gestureDetector = new GestureDetector(this, new MyGestureListener());

        // Set onTouchListener to handle touch events
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        viewFlipper.showPrevious();
                    } else {
                        viewFlipper.showNext();
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
