package com.example.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the avatar drawable and convert it to a bitmap
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.avatar, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        // Get the notification manager
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Create an intent for the notification
        Intent inNotify = new Intent(getApplicationContext(), MainActivity.class);
        inNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this, REQUEST_CODE, inNotify, PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a big picture style for the notification
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.avatar, null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by Manas")
                .setSummaryText("Image message");

        // Create an inbox style for the notification
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("D")
                .addLine("E")
                .addLine("F")
                .addLine("G")       // only showing 7 lines, so till this
                .addLine("H")
                .addLine("G")
                .addLine("H")
                .setBigContentTitle("Full message")
                .setSummaryText("Message from Manas");

        // Build the notification
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // For Android Oreo and above, create a notification channel
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.avatar)
                    .setContentText("New Message")
                    .setSubText("New Message from Manas")
                    .setChannelId(CHANNEL_ID)
                    .setOngoing(true)
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                    .build();           // must be needed in last
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        } else {
            // For older Android versions, build the notification without a channel
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.avatar)
                    .setContentText("New Message")
                    .setSubText("New Message from Manas")
                    .setOngoing(true)
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                    .build();
        }

        // Show the notification
        nm.notify(NOTIFICATION_ID, notification);
    }
}
