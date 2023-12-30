package com.example.myfirsttoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_toast, btn_custom_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Display a home screen toast without any clicking
        Toast.makeText(getApplicationContext(), "Welcome using long duration", Toast.LENGTH_LONG).show();

        // Create a default toast and show it when the default toast button is clicked
        btn_toast = findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create and show a Toast for the particular button
                Toast.makeText(getApplicationContext(), "Default Toast", Toast.LENGTH_SHORT).show();
            }
        });

        // Create a custom toast and show it when the custom toast button is clicked
        btn_custom_toast = findViewById(R.id.btn_custom_toast);
        btn_custom_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Toast object
                Toast toast = new Toast(getApplicationContext());

                // Inflate the custom layout for the toast
                View view = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.viewContainerLayout));

                // Set the custom view for the toast
                toast.setView(view);

                // Set the text for the custom toast message
                TextView txtmsg = view.findViewById(R.id.txtmsg);
                txtmsg.setText("Message sent successfully");

                // Set the duration and gravity for the toast
                toast.setDuration(toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.setGravity(Gravity.TOP | Gravity.END,0,0);

                // Show the custom toast message
                toast.show();
            }
        });
    }
}
