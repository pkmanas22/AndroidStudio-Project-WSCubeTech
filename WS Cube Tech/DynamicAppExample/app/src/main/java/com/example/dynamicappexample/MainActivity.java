package com.example.dynamicappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView; // Declare a ListView variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView); // Initialize the listView variable by finding the view with the appropriate ID from the layout

        String url = "https://jsonplaceholder.typicode.com/users"; // The URL for making the HTTP GET request

        ArrayList<String> arrNames = new ArrayList<>(); // Create an ArrayList to store the names

        AndroidNetworking.initialize(this); // Initialize the AndroidNetworking library

        AndroidNetworking.get(url) // Create an HTTP GET request
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() { // Make the request and handle the response
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("RES", response.toString()); // Log the response for debugging purposes

                        // Parsing the JSON response
                        try {
                            for (int index = 0; index < response.length(); index++) {
                                JSONObject objResult = response.getJSONObject(index);
                                String name = objResult.getString("name"); // Get the name from each JSON object

                                arrNames.add(name); // Add the name to the ArrayList

                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrNames);

                                listView.setAdapter(arrayAdapter); // Set the adapter for the ListView
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace(); // Print the error stack trace for debugging purposes
                        Log.e("ERROR", anError.toString()); // Log the error message for debugging purposes
                    }
                });
    }
}