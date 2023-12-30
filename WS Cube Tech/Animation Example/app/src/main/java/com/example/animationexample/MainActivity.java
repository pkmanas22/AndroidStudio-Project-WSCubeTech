package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textanim;
    Button translate,rotate,scale,alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textanim = findViewById(R.id.textanim);
        translate = findViewById(R.id.translate);
        rotate = findViewById(R.id.rotate);
        scale = findViewById(R.id.scale);
        alpha = findViewById(R.id.alpha);

//        Animation move = AnimationUtils.loadAnimation(this,R.anim.move);   --> can use here

        translate.setOnClickListener(new  View.OnClickListener(){
            public void onClick(View view){
                Animation move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                textanim.startAnimation(move);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                textanim.startAnimation(rotate);
            }
        });

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                textanim.startAnimation(scale);
            }
        });

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                textanim.startAnimation(alpha);
            }
        });

    }
}