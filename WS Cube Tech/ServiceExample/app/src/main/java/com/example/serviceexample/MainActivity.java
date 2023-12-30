package com.example.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons from layout
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        // Set click listener for the "Start" button
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the MusicService
                Intent startServiceIntent = new Intent(MainActivity.this, MusicService.class);
                // Start the MusicService
                startService(startServiceIntent);
            }
        });

        // Set click listener for the "Stop" button
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to stop the MusicService
                Intent stopServiceIntent = new Intent(MainActivity.this, MusicService.class);
                // Stop the MusicService
                stopService(stopServiceIntent);
            }
        });
    }
}
