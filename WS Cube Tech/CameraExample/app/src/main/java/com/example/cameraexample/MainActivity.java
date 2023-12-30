package com.example.cameraexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Views
    ImageView imgCamera;
    Button btnCamera;

    // Request code for the camera activity
    private final int CAMERA_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imgCamera = findViewById(R.id.imgCamera);
        btnCamera = findViewById(R.id.btnCamera);

        // Set click listener for the "Take Photo" button
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to open the device's camera app
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // Start the camera activity and expect a result using the defined request code
                startActivityForResult(iCamera, CAMERA_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if the result is OK and the request code matches the camera request code
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQ_CODE) {
                // Retrieve the captured image as a Bitmap from the data extras
                Bitmap img = (Bitmap) data.getExtras().get("data");

                // Display the captured image in the ImageView
                imgCamera.setImageBitmap(img);
            }
        }
    }
}