package com.example.lightsensorexample;

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
            // Get the default light sensor
            Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

            if (lightSensor != null) {
                // Register this activity as a listener for the light sensor
                sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_UI);
            } else {
                // Display a toast message if the light sensor is not detected
                Toast.makeText(this, "Sensor not detected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Check if the changed sensor is the light sensor
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            // Display the light sensor values on the TextView
            TextView txtValues = findViewById(R.id.txtValues);
            txtValues.setText("Values: " + sensorEvent.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // This method is not used in this example
    }
}
