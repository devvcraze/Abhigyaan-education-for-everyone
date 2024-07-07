package com.example.abhigyaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class coordinationActivity extends AppCompatActivity {
    CardView cardView,sarthak,atharva,kashyap,naman,khusboo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coordination);
        cardView=findViewById(R.id.aastha);
        sarthak=findViewById(R.id.sarthak);
        atharva=findViewById(R.id.atharva);
        kashyap=findViewById(R.id.kashyup);
        naman=findViewById(R.id.naman);
        khusboo=findViewById(R.id.khushboo);
        khusboo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/khushboojain29?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        sarthak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/sarthak-arora-a6ba9618b?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        atharva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/atharva-bhandakkar-170827273?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        naman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/naman-kamra-95b962268?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        kashyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/kumar-kashyap-0155011b6?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/aastha-jain-957a18257?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void gotourl(String url) {
        try {
            Uri uri = Uri.parse(url);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (Exception e) {
            Toast.makeText(this, "No LinkedIn profile found", Toast.LENGTH_SHORT).show();
        }
    }
}