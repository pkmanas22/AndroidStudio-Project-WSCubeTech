package com.example.alarmmanagerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Constant to define the request code for the PendingIntent
    static final int ALARM_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the EditText to input the time
        EditText edtTime = findViewById(R.id.edtTime);

        // Get the AlarmManager service
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Set a click listener for the "Set Alarm" button
        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the time entered by the user in seconds
                int time = Integer.parseInt(edtTime.getText().toString());

                // Calculate the trigger time in milliseconds
                long triggerTime = System.currentTimeMillis() + (time * 1000);

                // Create an Intent for the broadcast receiver
                Intent iBroadcast = new Intent(MainActivity.this, MyReceiver.class);

                // Create a PendingIntent for the broadcast using the request code
                PendingIntent pi = PendingIntent.getBroadcast(
                        MainActivity.this,
                        ALARM_REQ_CODE,
                        iBroadcast,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                // Set the alarm using AlarmManager
                // RTC_WAKEUP ensures the device wakes up for the alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pi);
            }
        });
    }
}
