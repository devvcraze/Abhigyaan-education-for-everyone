package com.example.abhigyaan;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class vol_mess_batch extends AppCompatActivity {
    TextView volunteer1, volunteer2, volunteer3, volunteer4, volunteer5, volunteer6, volunteer7, volunteer8, volunteer9, volunteer10, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vol_mess_batch);
        day = findViewById(R.id.day);
        volunteer1 = findViewById(R.id.member1);
        volunteer2 = findViewById(R.id.member2);
        volunteer3 = findViewById(R.id.member3);
        volunteer4 = findViewById(R.id.member4);
        volunteer5 = findViewById(R.id.member5);
        volunteer6 = findViewById(R.id.member6);
        volunteer7 = findViewById(R.id.member7);
        volunteer8 = findViewById(R.id.member8);
        volunteer9 = findViewById(R.id.member9);
        volunteer10 = findViewById(R.id.member10);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("MESS BATCH");

        // Get the current day of the week
        String currentDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(Calendar.getInstance().getTime());

        // Update the day TextView
        day.setText(currentDay);

        myRef.child(currentDay).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                volunteer1.setText(dataSnapshot.child("Volunteer1").getValue(String.class));
                volunteer2.setText(dataSnapshot.child("Volunteer2").getValue(String.class));
                volunteer3.setText(dataSnapshot.child("Volunteer3").getValue(String.class));
                volunteer4.setText(dataSnapshot.child("Volunteer4").getValue(String.class));
                volunteer5.setText(dataSnapshot.child("Volunteer5").getValue(String.class));
                volunteer6.setText(dataSnapshot.child("Volunteer6").getValue(String.class));
                volunteer7.setText(dataSnapshot.child("Volunteer7").getValue(String.class));
                volunteer8.setText(dataSnapshot.child("Volunteer8").getValue(String.class));
                volunteer9.setText(dataSnapshot.child("Volunteer9").getValue(String.class));
                volunteer10.setText(dataSnapshot.child("Volunteer10").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle possible errors
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.back);
        videoView.setVideoURI(videoUri);
        videoView.start();
        videoView.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true)); // Loop the video
    }
}
