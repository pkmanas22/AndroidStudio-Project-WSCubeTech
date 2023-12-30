package com.example.lottieanimationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView laview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        can use this also
//        laview.setAnimation(R.raw.lottie);
//        laview.playAnimation();
//        laview.loop(true);
    }
}