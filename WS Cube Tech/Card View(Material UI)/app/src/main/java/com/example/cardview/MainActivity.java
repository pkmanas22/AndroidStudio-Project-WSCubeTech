package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CardView cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardview = findViewById(R.id.cardview);

        cardview.setRadius(15.0f);
        cardview.setCardElevation(15.0f);
        cardview.setUseCompatPadding(true);

    }
}