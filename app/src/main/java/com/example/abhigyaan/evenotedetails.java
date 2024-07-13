package com.example.abhigyaan;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class evenotedetails extends AppCompatActivity {
    EditText titleEditText, contentEditText;
    ImageButton saveNoteBtn;

    private boolean isEditMode = false;
    private String docId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenotedetails);
        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteBtn = findViewById(R.id.save_note_btn);

        saveNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

        // Initialize isEditMode and docId based on your logic here
    }

    void saveNote() {
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();

        if (noteTitle == null || noteTitle.isEmpty()) {
            titleEditText.setError("Title is required");
            return;
        }

        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);
    }

    void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;

        if (isEditMode) {
            // update the note
            documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        } else {
            // create new note
            documentReference = Utility.getCollectionReferenceForNotes().document();
        }

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // note is added
                    Utility.showToast(evenotedetails.this, "Note added successfully");
                    finish();
                } else {
                    Utility.showToast(evenotedetails.this, "Failed while adding note");
                }
            }
        });
    }
}
