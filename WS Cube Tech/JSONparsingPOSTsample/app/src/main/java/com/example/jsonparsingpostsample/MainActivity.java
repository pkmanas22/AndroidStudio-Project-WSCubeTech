package com.example.jsonparsingpostsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize AndroidNetworking
        AndroidNetworking.initialize(this);

        // Make a POST request
        AndroidNetworking.post("https://wscubetech.org/android-course/get-data.php")
                .addBodyParameter("course_id","1")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle successful response
                        Log.d("Res", response.toString());

                        try {
                            // Extract data from the response
                            JSONObject objData = response.getJSONObject("data");
                            String name = objData.getString("name");

                            Log.d("Name", name);

                            JSONObject objDes = objData.getJSONObject("description");
                            String extension = objDes.getString("extension");

                            Log.d("Extension", extension);

                        } catch (JSONException e) {
                            // Handle JSON parsing error
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        // Handle error in network request
                        anError.printStackTrace();
                    }
                });
    }
}
