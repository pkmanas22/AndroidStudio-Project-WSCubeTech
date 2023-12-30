package com.example.alarmmanagerexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MyReceiver extends BroadcastReceiver {

    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        // Create a MediaPlayer instance to play the ringtone
        mp = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);

        // Set looping to continuously play the ringtone
        mp.setLooping(true);

        // Start playing the ringtone
        mp.start();
    }
}
