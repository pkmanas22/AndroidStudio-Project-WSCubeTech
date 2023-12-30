package com.example.proximitysensorexample;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the SensorManager to manage sensor interactions
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {
            // Get the default proximity sensor
            Sensor proxiSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proxiSensor != null) {
                // Register this activity as a listener for the proximity sensor
                sensorManager.registerListener(this, proxiSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }else {
                // Display a toast message if the light sensor is not detected
                Toast.makeText(this, "Sensor not detected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Check if the changed sensor is the proximity sensor
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            // Display the proximity sensor values on the TextView
            TextView txtValues = findViewById(R.id.txtValues);
            txtValues.setText("Values: " + sensorEvent.values[0]);

            // Check if the object is near or far based on the sensor value
            if (sensorEvent.values[0] > 0) {
                // Display a toast message indicating the object is far
                Toast.makeText(this, "Object is far", Toast.LENGTH_SHORT).show();
            } else {
                // Display a toast message indicating the object is near
                Toast.makeText(this, "Object is near", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // This method is not used in this example
    }
}
