package com.example.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    AppCompatButton btnLogout; // Declare a variable to reference the logout button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Set the layout for this activity using the specified XML file

        btnLogout = findViewById(R.id.btnLogout); // Connect the variable to the actual logout button in the layout

        btnLogout.setOnClickListener(new View.OnClickListener() { // Set a click listener for the logout button
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE); // Get the SharedPreferences instance with the name "login"

                SharedPreferences.Editor editor = pref.edit(); // Create a SharedPreferences editor for making changes to the data

                editor.putBoolean("flag", false); // Set the boolean value "flag" to false

                editor.apply(); // Save the changes to the SharedPreferences

                Intent iLogin = new Intent(HomeActivity.this, LoginActivity.class); // Create an Intent to navigate to the LoginActivity
                startActivity(iLogin); // Start the LoginActivity
                finish(); // Finish and close the HomeActivity so the user can't navigate back to it without logging in again
            }
        });
    }
}