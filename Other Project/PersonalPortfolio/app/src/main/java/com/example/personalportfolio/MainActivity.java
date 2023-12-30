package com.example.personalportfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout call_layout,mail_layout;
    AppCompatButton exploreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call_layout = findViewById(R.id.llCall);
        mail_layout = findViewById(R.id.llMail);
        exploreBtn = findViewById(R.id.exploreBtn);

//        animation for card profile
        CardView cardProfile = findViewById(R.id.cardProfile);
        Animation cardAlpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
        cardProfile.setAnimation(cardAlpha);

        call_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"calling...",Toast.LENGTH_SHORT).show();
            }
        });

        mail_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "mailing...", Toast.LENGTH_SHORT).show();
            }
        });

        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNext = new Intent(MainActivity.this,InsideExplore.class);
                startActivity(intentNext);
            }
        });
    }
}