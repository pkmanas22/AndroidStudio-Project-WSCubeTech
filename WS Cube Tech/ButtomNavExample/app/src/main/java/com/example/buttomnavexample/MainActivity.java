package com.example.buttomnavexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the BottomNavigationView in the layout
        bnView = findViewById(R.id.bnView);

        // Set the listener for item selection in the BottomNavigationView
        bnView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Check the selected item ID and load the corresponding fragment
                if (id == R.id.nav_home){
                    loadFragment(new HomeFragment(), false);
                } else if (id == R.id.nav_Search) {
                    loadFragment(new SearchFragment(), false);
                } else if (id == R.id.nav_utilities) {
                    loadFragment(new UtilitiesFragment(), false);
                } else if (id == R.id.nav_contact) {
                    loadFragment(new ContactFragment(), false);
                } else {     // profile
                    loadFragment(new ProfileFragment(), true);
                }
                return true;
            }
        });

        // Set the initial selected item in the BottomNavigationView
        bnView.setSelectedItemId(R.id.nav_home);
    }

    public void loadFragment(Fragment fragment, boolean flag) {
        // Get the FragmentManager
        FragmentManager fm = getSupportFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction ft = fm.beginTransaction();

        // Replace or add the fragment to the container based on the flag
        if (flag) {
            ft.add(R.id.container, fragment);
        } else {
            ft.replace(R.id.container, fragment);
        }

        // Commit the transaction to apply the changes
        ft.commit();
    }
}
