package com.example.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find the login button in the layout and assign it to the btnLogin variable
        btnLogin = findViewById(R.id.btnLogin);

        // Set an onClickListener to the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for user verification should go here

                // Get the SharedPreferences instance named "login" in private mode
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);

                // Create a SharedPreferences.Editor to insert data into the SharedPreferences
                SharedPreferences.Editor editor = pref.edit();

                // Insert a boolean value with the key "flag" and set it to true
                editor.putBoolean("flag", true);

                // Apply the changes to the SharedPreferences
                editor.apply();

                // Create an intent to start the HomeActivity
                Intent iHome = new Intent(LoginActivity.this, HomeActivity.class);

                // Start the HomeActivity and finish the current LoginActivity
                startActivity(iHome);
                finish();
            }
        });
    }
}