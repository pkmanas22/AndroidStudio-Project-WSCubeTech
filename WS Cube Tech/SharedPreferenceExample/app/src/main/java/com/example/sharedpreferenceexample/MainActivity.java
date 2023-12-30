package com.example.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handler to delay execution of code for 3 seconds (3000 milliseconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Get the SharedPreferences object named "login"
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);

                // Get the boolean value associated with key "flag"
                // The second argument is a default value to be returned if the key is not found
                Boolean check = pref.getBoolean("flag", false);

                // Intent object to be used for navigating to the next activity
                Intent iNext;

                // Check the value of "flag" in SharedPreferences
                if (check){     // If true (User is logged in)
                    // Navigate to the HomeActivity if the user is logged in
                    iNext = new Intent(MainActivity.this, HomeActivity.class);
                }else {         // If false (First time or user is logged out)
                    // Navigate to the LoginActivity if the user is logged out or it's the first time
                    iNext = new Intent(MainActivity.this, LoginActivity.class);
                }

                // Start the next activity based on the value of "flag"
                startActivity(iNext);

                // Finish the current activity to prevent going back to it when pressing the back button
                finish();
            }
        }, 3000); // Delay duration in milliseconds (3 seconds)
    }
}