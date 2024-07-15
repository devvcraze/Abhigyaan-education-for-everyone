package com.example.abhigyaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class contactusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contactus);

        initializeImageViews();


    }

    private void initializeImageViews() {
        // Sarthak
        setImageClickListener(R.id.whatsappsarthak, "https://wa.me/+918527282882");
        setImageClickListener(R.id.instagramsarthak, "https://www.instagram.com/sarthakkk_arora?igsh=enF2MGFyb2JhNjlv");
        setImageClickListener(R.id.linkdinsarthak, "https://www.linkedin.com/in/sarthak-arora-a6ba9618b?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");

        // Aastha
        setImageClickListener(R.id.whatsappaastha, "https://wa.me/+919104329671");
        setImageClickListener(R.id.instagramastha, "https://www.instagram.com/aasthaj07?igsh=MWozOGozdHdrMDN6cQ==");
        setImageClickListener(R.id.linkdinastha, "https://www.linkedin.com/in/aastha-jain-957a18257?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");

        // Atharva
        setImageClickListener(R.id.whatsappatharva, "https://wa.me/+918962149343");
        setImageClickListener(R.id.instagramatharva, "https://www.instagram.com/atharva.bhandakkar?igsh=MXkwOG8yY2N0c3lhaQ==");
        setImageClickListener(R.id.linkdinatharva, "https://www.linkedin.com/in/atharva-bhandakkar-170827273?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");

        // Kashyap
        setImageClickListener(R.id.whatsappkashyap, "https://wa.me/+916206671966");
        setImageClickListener(R.id.instagramkashyap, "https://www.instagram.com/kumar_kashyap_username");
        setImageClickListener(R.id.linkdinkashyap, "https://www.linkedin.com/in/kumar-kashyap-0155011b6?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");

        // Naman
        setImageClickListener(R.id.whatsappnaman, "https://wa.me/+918587937882");
        setImageClickListener(R.id.instagramnaman, "https://www.instagram.com/naman__kamra?igsh=MXBkdjZxOWMxdW1mZQ==");
        setImageClickListener(R.id.linkdinnaman, "https://www.linkedin.com/in/naman-kamra-95b962268");

        // Khushboo
        setImageClickListener(R.id.whatsappkhusboo, "https://wa.me/+918955539597");
        setImageClickListener(R.id.instagramkhusboo, "https://www.instagram.com/khushboo_jain_username");
        setImageClickListener(R.id.linkdinkhusboo, "https://www.linkedin.com/in/khushboojain29?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
    }

    private void setImageClickListener(int imageId, String url) {
        ImageView imageView = findViewById(imageId);
        imageView.setOnClickListener(v -> openUrl(url));
    }

    private void openUrl(String url) {
        if (url != null && !url.isEmpty()) {
            try {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Error opening the link", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No link available", Toast.LENGTH_SHORT).show();
        }
    }
}