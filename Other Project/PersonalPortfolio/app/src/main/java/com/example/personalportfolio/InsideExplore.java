package com.example.personalportfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class InsideExplore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_explore);

        TextView autoResult = findViewById(R.id.autoResult);

        AppCompatAutoCompleteTextView autoDetails = findViewById(R.id.autoDetails);
        ListView detailedList = findViewById(R.id.detailedList);
        Spinner spinnerNextPage = findViewById(R.id.spinnerNextPage);

//        auto complete
        ArrayList<String> details = new ArrayList<>();
        details.add("Full Name");
        details.add("Mobile No.");
        details.add("Gmail ID");
        details.add("Father Name");
        details.add("Mother Name");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,details);
        autoDetails.setAdapter(adapter);
        autoDetails.setThreshold(1);

        autoDetails.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = (String) adapterView.getItemAtPosition(i);
                autoResult.setText(selection);
            }
        });
    }
}