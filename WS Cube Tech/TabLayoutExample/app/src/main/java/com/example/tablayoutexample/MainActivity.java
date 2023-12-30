package com.example.tablayoutexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabMode;
    ViewPager viewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabMode = findViewById(R.id.tabMode);
        viewPage = findViewById(R.id.viewPage);


        viewPagerMessengerAdapter adapter = new viewPagerMessengerAdapter(getSupportFragmentManager());
        viewPage.setAdapter(adapter);

        tabMode.setupWithViewPager(viewPage);
    }
}












