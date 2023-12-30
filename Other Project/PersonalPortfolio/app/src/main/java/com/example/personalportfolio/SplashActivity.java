package com.example.personalportfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppCompatImageView splashAvatar = findViewById(R.id.splashAvatar);

//        android reserved animation
        Animation defaultAnim = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
        splashAvatar.startAnimation(defaultAnim);

//        animation by creating
        Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
        Animation scaleOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale_out);
/*        splashAvatar.startAnimation(alpha);
        splashAvatar.startAnimation(scaleOut);*/

//        for use simultaneously
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alpha);
        animationSet.addAnimation(scaleOut);
        splashAvatar.startAnimation(animationSet);


        Intent iHome = new Intent(SplashActivity.this, MainActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(iHome);
                finish();
            }
        }, 2000); // in milliseconds

    }
}