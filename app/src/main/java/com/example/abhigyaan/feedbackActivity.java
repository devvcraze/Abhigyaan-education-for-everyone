package com.example.abhigyaan;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedbackActivity extends AppCompatActivity {
    EditText nameEditText, feedbackEditText;
    ImageButton saveFeedbackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        nameEditText = findViewById(R.id.notes_title_text);
        feedbackEditText = findViewById(R.id.notes_content_text);
        saveFeedbackBtn = findViewById(R.id.save_note_btn);

        saveFeedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFeedback();
            }
        });
    }

    void saveFeedback() {
        String userName = nameEditText.getText().toString();
        String userFeedback = feedbackEditText.getText().toString();

        if (userName == null || userName.isEmpty()) {
            nameEditText.setError("Name is required");
            return;
        }

        if (userFeedback == null || userFeedback.isEmpty()) {
            feedbackEditText.setError("Feedback is required");
            return;
        }

        Feedback feedback = new Feedback(userName, userFeedback, System.currentTimeMillis());

        saveFeedbackToFirebase(feedback);
    }

    void saveFeedbackToFirebase(Feedback feedback) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference feedbackRef = database.getReference("feedback");

        // Generate a new unique key for each feedback
        String key = feedbackRef.push().getKey();

        feedbackRef.child(key).setValue(feedback).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(feedbackActivity.this, "Your Feedback was Received\n           Thank You", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(feedbackActivity.this, "Failed while adding Feedback", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
