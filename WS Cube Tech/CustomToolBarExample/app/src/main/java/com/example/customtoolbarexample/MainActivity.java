package com.example.customtoolbarexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        // step-1
        // Set the custom toolbar as the support action bar
        setSupportActionBar(toolbar);
//        setActionBar();     --> if normal toolbar used in xml file

        // step-2
        // Enable the back button in the action bar (not required for the first activity)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set the title of the action bar
        getSupportActionBar().setTitle("My Toolbar");

        // step-3
//        toolbar.setTitle("My Toolbar");     it does not effect as lowest priority than app name
        // Set the subtitle of the custom toolbar
        toolbar.setSubtitle("My Sub Title");

    }


    // step-4
    // Inflate the menu layout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Handle click events of the menu items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.opt_new) {
            Toast.makeText(this, "new file created", Toast.LENGTH_SHORT).show();
        }else if (itemId == R.id.opt_open) {
            Toast.makeText(this, "file is opened", Toast.LENGTH_SHORT).show();
        }else if (itemId == R.id.opt_save) {
            Toast.makeText(this, "file is saved", Toast.LENGTH_SHORT).show();
        }else {
//        }else if (itemId == android.R.id.home) {      // Handle the back button
            Toast.makeText(this,"go to previous activity",Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}










