package com.example.pkmanas;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMsgService extends FirebaseMessagingService {

    // This method is called when a new token is generated or an existing token is refreshed
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        Log.d("RefreshedToken", token);
    }

    // This method is called when a new message is received
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        // Check if the message has a notification payload
        if (message.getNotification() != null) {
            pushNotification(
                    message.getNotification().getTitle(),
                    message.getNotification().getBody());
        }
    }

    // Method to push a notification to the user's device
    private void pushNotification(String title, String msg) {
        // Get the notification manager
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;

        final String CHANNEL_ID = "push_noti";

        // Create an intent for the notification
        Intent iNotify = new Intent(this, MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this,100,iNotify, PendingIntent.FLAG_UPDATE_CURRENT);

        // Check if the Android version is Oreo or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Custom Channel";
            String description = "Channel for push Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            // Create a notification channel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Create a notification with a channel ID
            if (nm != null) {
                nm.createNotificationChannel(channel);

                notification = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(pi)
                        .setContentTitle(title)
                        .setSubText(msg)
                        .setAutoCancel(true)
                        .setChannelId(CHANNEL_ID)
                        .build();
            }
            else {
                notification = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(pi)
                        .setContentTitle(title)
                        .setSubText(msg)
                        .setAutoCancel(true)
                        .build();
            }

            // Notify the user
            if (nm != null) {
                nm.notify(1,notification);
            }
        }

    }

}
