package com.example.abhigyaan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BirthdayActivity extends AppCompatActivity {

    private EditText etVolunteerName, etVolunteerBirthdate;
    private Button btnSaveBirthday;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        etVolunteerName = findViewById(R.id.et_volunteer_name);
        etVolunteerBirthdate = findViewById(R.id.et_volunteer_birthdate);
        btnSaveBirthday = findViewById(R.id.btn_save_birthday);

        databaseReference = FirebaseDatabase.getInstance().getReference("volunteers");

        btnSaveBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBirthday();
            }
        });
    }

    private void saveBirthday() {
        String name = etVolunteerName.getText().toString().trim();
        String birthdate = etVolunteerBirthdate.getText().toString().trim();

        if (name.isEmpty() || birthdate.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String id = databaseReference.push().getKey();
        Volunteer volunteer = new Volunteer(id, name, birthdate);
        databaseReference.child(id).setValue(volunteer);

        Toast.makeText(this, "Birthday saved!", Toast.LENGTH_SHORT).show();
        etVolunteerName.setText("");
        etVolunteerBirthdate.setText("");
    }
}
