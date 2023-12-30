package com.example.intentpassingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext;

        btnNext = findViewById(R.id.btnNext);

        // value is set in main activity and send to second activity
        Intent iNext;
        iNext = new Intent(MainActivity.this, SecondActivity.class);
        iNext.putExtra("title", "home");
        iNext.putExtra("StudentName","Manas");
        iNext.putExtra("rollNo",20);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(iNext);

//                iNext = new Intent(getApplicationContext());      can use
//                Intent iNext;       --> can use here
//                iNext = new Intent(MainActivity.this, SecondActivity.class);
            }
        });
    }
}