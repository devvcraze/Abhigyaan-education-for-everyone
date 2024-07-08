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
    CardView cardView,sarthak,atharva,kashyap,naman,khusboo,ujwal,tejas,diya,vinay,pulkit,jeet,kavya,shanay,tejas2,shubhi,vedant,ashish,saurabh,satyam,yash,mitali,krishi,siddhant;

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
        ujwal=findViewById(R.id.ujwal);
        tejas=findViewById(R.id.tejas);
        diya=findViewById(R.id.diya);
        pulkit=findViewById(R.id.pulkit);
        jeet=findViewById(R.id.jeet);
        vinay=findViewById(R.id.vinay);
        kavya=findViewById(R.id.kavya);
        shanay=findViewById(R.id.shanay);
        tejas2=findViewById(R.id.tejas2);
        shubhi=findViewById(R.id.shubhi);
        vedant=findViewById(R.id.vedant);
        ashish=findViewById(R.id.ashish);
        satyam=findViewById(R.id.satyam);
        saurabh=findViewById(R.id.saurabh);
        mitali=findViewById(R.id.mitali);
        yash=findViewById(R.id.yash);
        krishi=findViewById(R.id.krishi);
        siddhant=findViewById(R.id.siddhant);

        saurabh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/saurabh-gandhi-2b836b193?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        satyam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/satyam-mhaske-3324771a7?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        yash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/yash-kasliwal-16b63116b?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        mitali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/mitali-doshi-71b376247?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        krishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/krishi-agrawal75?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        siddhant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("");
            }
        });
        kavya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/kavya-3a0105205?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        shanay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/shanay-gandhi-16433720a?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        shubhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/shubhi-bhandari-683339205?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        tejas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/tejas-khadke?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        vedant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/vedant-alimchandani-9b21a6205?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        ashish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/a-pankhedkar?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        ujwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/ujjwal-kumar-055400250?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        tejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/tejasbajaj?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        diya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/diya-rastogi-b32bab249?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        vinay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("");
            }
        });
        pulkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/pulkit-singla-b56b5a122?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        jeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://www.linkedin.com/in/jeet-lohiya-96176522a?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
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