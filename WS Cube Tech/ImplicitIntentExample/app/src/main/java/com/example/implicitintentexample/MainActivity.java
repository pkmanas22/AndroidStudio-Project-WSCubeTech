package com.example.implicitintentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDial,btnMsg,btnGmail,btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        btnDial = findViewById(R.id.btnDial);
        btnMsg = findViewById(R.id.btnMsg);
        btnGmail = findViewById(R.id.btnGmail);
        btnShare = findViewById(R.id.btnShare);

        // Set click listeners for each button
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create intent to dial a phone number
                Intent iDial = new Intent();
                iDial.setAction(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +919876543210"));
                // Start activity to dial the phone number
                startActivity(iDial);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create intent to send a text message
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:" + Uri.encode("+919876543210")));
                iMsg.putExtra("sms_body","Please solve this issue.");
                // Start activity to send the text message
                startActivity(iMsg);
            }
        });

        btnGmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Create intent to send an email
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com","xyz@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please resolve the issue");
                // Show the app chooser dialog and start the activity to send the email
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create intent to share a text message
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Download this amazing app, https://play.google.com/store/apps/details?id=com.google.android.googlequicksearchbox&hl=en_US&pli=1");
                // Show the app chooser dialog and start the activity to share the text message
                startActivity(Intent.createChooser(iShare,"Share via"));
            }
        });
    }
}
