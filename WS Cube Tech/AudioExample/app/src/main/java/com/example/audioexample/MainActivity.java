package com.example.audioexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // Views
    Button btnPause, btnPlay, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        btnPause = findViewById(R.id.btnPause);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);

        // Create a new instance of MediaPlayer to play audio
        MediaPlayer audio = new MediaPlayer();

        // Set the audio stream type to STREAM_MUSIC to ensure proper volume control
        audio.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // Define the paths for the audio resources (raw folder) and online audio URL
        String audioPath = "android.resource://" + getPackageName() + "/raw/kahanisuno";
        String onlinePath = "http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/music/lose.ogg";

        // Convert the paths into Uri objects
        Uri audioUri = Uri.parse(audioPath);
        Uri onlineUri = Uri.parse(onlinePath);

        try {
            // Set the data source for the MediaPlayer to the online audio URL
            audio.setDataSource(this, onlineUri);

            // Prepare the MediaPlayer to play the online audio
            audio.prepare();
        } catch (IOException e) {
            // Handle any IOException that might occur during setting data source or preparation
            throw new RuntimeException(e);
        }

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio.pause(); // Pause the audio playback
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio.start(); // Start or resume the audio playback
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio.pause(); // Pause the audio playback
                audio.seekTo(0); // Seek to the beginning of the audio (reset)
            }
        });
    }
}