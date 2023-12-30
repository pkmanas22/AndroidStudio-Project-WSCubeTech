package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    // Declare a MediaPlayer instance to manage audio playback
    MediaPlayer mp;

    // This method is not used in this example
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // This method is called when the service is started
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Create a MediaPlayer instance and associate it with the default ringtone sound
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        // Set the MediaPlayer to loop the sound indefinitely
        mp.setLooping(true);

        // Start playing the sound
        mp.start();

        // Indicate how the service should behave if it's killed and restarted by the system
        // START_NOT_STICKY: The service won't be restarted automatically.
        // It remains stopped until a new start command is received.
        // Suitable for tasks that need to be executed once.
        return START_NOT_STICKY;

        // START_STICKY: The service will be restarted automatically.
        // The intent passed to onStartCommand will be null.
        // Useful for services that need to be restarted to continue tasks, like music playback.
        // return START_STICKY;

        // START_REDELIVER_INTENT: The service will be restarted automatically,
        // and the last intent passed to onStartCommand will be redelivered.
        // Suitable for services that must resume processing exactly where they left off.
        // return START_REDELIVER_INTENT;
    }

    // This method is called when the service is destroyed
    @Override
    public void onDestroy() {

        // Stop the MediaPlayer and release its resources
        mp.stop();
        mp.release();

        // Call the superclass's onDestroy method to perform necessary cleanup
        super.onDestroy();
    }
}
