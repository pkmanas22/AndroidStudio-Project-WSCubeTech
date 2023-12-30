package com.example.customdialogboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog customDialog = new Dialog(this);
        customDialog.setContentView(R.layout.custom_dialog_layout);
        customDialog.setCancelable(false);

        Button btnOkay = customDialog.findViewById(R.id.btnOkay);

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Thank you, for your order",Toast.LENGTH_SHORT).show();
                customDialog.dismiss();
            }
        });

        customDialog.show();
    }
}