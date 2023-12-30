package com.example.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    Spinner spinner;

    AutoCompleteTextView autocomp;

//    int[] no = new int[]{1,2,3,4,5};

//    ListView
    ArrayList<String> arrName = new ArrayList<>();      // list view
    ArrayList<String> arrID = new ArrayList<>();        // spinner
    ArrayList<String> arrLang = new ArrayList<>();      // Auto Complete


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        spinner = findViewById(R.id.spinner);
        autocomp = findViewById(R.id.autocomp);

        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");
        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");
        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");
        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");
        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");
        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");
        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");
        arrName.add("Manas");
        arrName.add("Aswini");
        arrName.add("Subas");

//        You can use all three for array adapter

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrName);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrName);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrName);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position % 3 == 0){
                    Toast.makeText(MainActivity.this, "Manas is clicked", Toast.LENGTH_SHORT).show();
                } else if (position % 3 == 1){
                    Toast.makeText(MainActivity.this, "Aswini is clicked", Toast.LENGTH_SHORT).show();
                }else if (position % 3 == 2){
                    Toast.makeText(MainActivity.this, "Subas is clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        Spinner

        arrID.add("Adhar Card");
        arrID.add("Voter ID Card");
        arrID.add("PAN Card");
        arrID.add("Driving License Card");
        arrID.add("Ration Card");

        ArrayAdapter<String> spinnerAddapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,arrID);
        spinner.setAdapter(spinnerAddapter);


//        Auto Complete
        arrLang.add("C");
        arrLang.add("C++");
        arrLang.add("Java");
        arrLang.add("HTML");
        arrLang.add("JavaScript");
        arrLang.add("Python");

        ArrayAdapter<String> autoCompAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrLang);
        autocomp.setAdapter(autoCompAdapter);
        autocomp.setThreshold(1);       //after 1st enter it display for auto complete

    }
}