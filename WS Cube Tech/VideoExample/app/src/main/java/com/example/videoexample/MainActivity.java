package com.example.videoexample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the VideoView from the layout
        VideoView videoView = findViewById(R.id.videoView);

        // Define the path to the video resource in the "raw" folder
        String vPath = "android.resource://" + getPackageName() + "/raw/meme";

        // Set the video path and start playing the video
//        videoView.setVideoPath(vPath);
//        videoView.start();

        // Alternatively, you can use a Uri for the video path
//         Uri vUri = Uri.parse(vPath);

        // Define the online video URL
        String onlinePath = "https://file-examples.com/storage/fe7bb0e37864d66f29c40ee/2017/04/file_example_MP4_480_1_5MG.mp4";

        // Convert the online URL to a Uri
        Uri onlineUri = Uri.parse(onlinePath);

        // Set the online video Uri and start playing the video
        videoView.setVideoURI(onlineUri);
        videoView.start();

        // Create a MediaController to control video playback
        MediaController mediaController = new MediaController(this);

        // Set the MediaController to the VideoView and associate it with the video view
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
