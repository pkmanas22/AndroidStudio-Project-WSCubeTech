package com.example.intentpassingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


//        value shared in first activity, we have to receive in this activity
        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String StudentName = fromAct.getStringExtra("StudentName");
        int rollNo = fromAct.getIntExtra("rollNo",0);

        TextView studinfo;

        studinfo = findViewById(R.id.studinfo);

        studinfo.setText("Name: " + StudentName + ",\nRoll No: " + rollNo);
        getSupportActionBar().setTitle(title);
    }
}