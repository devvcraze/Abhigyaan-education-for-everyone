package com.example.abhigyaan;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogActivity extends AppCompatActivity {

    private EditText titleEditText, sectionEditText1, sectionEditText2, sectionEditText3;
    private Button addButton, cancelButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_item);

        titleEditText = findViewById(R.id.titleEditText);
        sectionEditText1 = findViewById(R.id.sectionEditText1);
        sectionEditText2 = findViewById(R.id.sectionEditText2);
        sectionEditText3 = findViewById(R.id.sectionEditText3);
        addButton = findViewById(R.id.addButton);
        cancelButton = findViewById(R.id.cancelButton);

        databaseReference = FirebaseDatabase.getInstance().getReference("items");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addItem() {
        String title = titleEditText.getText().toString().trim();
        String section1 = sectionEditText1.getText().toString().trim();
        String section2 = sectionEditText2.getText().toString().trim();
        String section3 = sectionEditText3.getText().toString().trim();

        if (TextUtils.isEmpty(title)) {
            titleEditText.setError("Title is required");
            return;
        }

        String key = databaseReference.push().getKey();
        Item newItem = new Item(key, title, section1, section2, section3);
        databaseReference.child(key).setValue(newItem);

        Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show();
        finish();
    }
}
