package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnFragA,btnFragB,btnFragC;
    String ROOT_FRAGMENT_TAG = "RootFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);

        loadFrag(new AFragment(), 0);      // default fragment

        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loadFrag(new AFragment(), 1);
                loadFrag(AFragment.getInstance("Manas", 25), 1);
            }
        });
        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new BFragment(), 1);
            }
        });
        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new CFragment(), 1);
            }
        });
    }

    public  void  loadFrag(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

//        Bundle bundle = new Bundle();
//        bundle.putString("Arg1", "Manas");
//        bundle.putInt("Arg2", 20);
//
//        fragment.setArguments(bundle);

        if (flag == 0) {
            ft.add(R.id.container, fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        } else {
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}
