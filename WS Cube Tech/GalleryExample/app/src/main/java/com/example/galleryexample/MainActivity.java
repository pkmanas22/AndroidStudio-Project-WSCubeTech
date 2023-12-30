package com.example.galleryexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Views
    ImageView imgGallery;
    Button btnGallery;

    // Request code for the gallery activity
    private final int GALLERY_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imgGallery = findViewById(R.id.imgGallery);
        btnGallery = findViewById(R.id.btnGallery);

        // Set click listener for the "Pick Image from Gallery" button
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to pick an image from the device's gallery
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                // Start the gallery activity and expect a result using the defined request code
                startActivityForResult(iGallery, GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if the result is OK and the request code matches the gallery request code
        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQUEST_CODE) {
                // Retrieve the selected image URI from the returned Intent and set it to the ImageView
                imgGallery.setImageURI(data.getData());
            }
        } else if (resultCode == RESULT_CANCELED) {
            // If the user canceled the gallery selection
            Toast.makeText(this, "Gallery selection canceled", Toast.LENGTH_SHORT).show();
        } else {
            // If there was an error in picking the image from the gallery
            Toast.makeText(this, "Error selecting image from gallery", Toast.LENGTH_SHORT).show();
        }
    }
}