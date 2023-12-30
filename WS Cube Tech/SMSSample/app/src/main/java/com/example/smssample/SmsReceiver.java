package com.example.smssample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // Retrieve the SMS message bundle from the intent
        Bundle bundle = intent.getExtras();

        // Extract the array of SMS PDUs (Protocol Data Units)
        Object[] smsObj = (Object[]) bundle.get("pdus");

        // Iterate through each SMS PDU
        for (Object obj : smsObj) {

//            for receiving
            // Convert PDU to SmsMessage
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);

            // Get the sender's phone number
            String mobNo = message.getDisplayOriginatingAddress();

            // Get the SMS message body
            String msg = message.getDisplayMessageBody();

            // Log the received message details
            Log.d("Message Details", "MOb No: " + mobNo + ", Msg: " + msg);


//            for sending
            // Create an SmsManager instance for sending SMS
            SmsManager smsManager = SmsManager.getDefault();

            // Send a sample SMS
            smsManager.sendTextMessage("+919999999999", "null", "Hello", null, null);
        }

    }
}
