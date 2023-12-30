package com.example.accelerometersensorexample;

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
            // Get the default accelerometer sensor
            Sensor acceleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if (acceleroSensor != null) {
                // Register this activity as a listener for the accelerometer sensor
                sensorManager.registerListener(this, acceleroSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        } else {
            // Display a toast message if the sensor service is not available
            Toast.makeText(this, "Sensor service not detected.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Check if the changed sensor is the accelerometer
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Display the accelerometer values on the TextView
            ((TextView) findViewById(R.id.txtValues)).setText("x: " + sensorEvent.values[0]
                    + ", y: " + sensorEvent.values[1] + ", z: " + sensorEvent.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // This method is not used in this example
    }
}
