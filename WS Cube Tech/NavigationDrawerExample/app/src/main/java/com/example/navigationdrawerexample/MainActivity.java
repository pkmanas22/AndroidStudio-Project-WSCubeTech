package com.example.navigationdrawerexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the DrawerLayout, NavigationView, and Toolbar
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        // Set the Toolbar as the ActionBar
        setSupportActionBar(toolbar);

        // Create an ActionBarDrawerToggle for the DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);

        // Add the ActionBarDrawerToggle to the DrawerLayout
        drawerLayout.addDrawerListener(toggle);

        // Sync the state of the ActionBarDrawerToggle
        toggle.syncState();

        // Load the HomeFragment initially
        loadFragment(new HomeFragment());

        // Set the listener for item selection in the NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Check the selected item ID and load the corresponding fragment
                if (id == R.id.optNotes) {
                    loadFragment(new NotesFragment());
                } else if (id == R.id.optHome) {
                    loadFragment(new HomeFragment());
                } else if (id == R.id.optSetting) {
                    loadFragment(new SettingFragment());
                } else { // logout
                    loadFragment(new LogoutFragment());
                }

                // Close the drawer after selecting an item
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // Close the drawer if it is open
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            // Handle the back button press normally
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        // Get the FragmentManager
        FragmentManager fm = getSupportFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction ft = fm.beginTransaction();

        // Add the fragment to the container
        ft.add(R.id.container, fragment);

        // Commit the transaction to apply the changes
        ft.commit();
    }
}
