package com.example.alertdialogsboxexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Single button dialog
        AlertDialog singleButtonDialog = new AlertDialog.Builder(this).create();

        singleButtonDialog.setTitle("Terms & conditions");
        singleButtonDialog.setIcon(R.drawable.baseline_info_24);
        singleButtonDialog.setMessage("Have you read all T & C");

        singleButtonDialog.setButton(DialogInterface.BUTTON_POSITIVE,"Yes, I've read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You can proceed now", Toast.LENGTH_SHORT).show();
            }
        });

        singleButtonDialog.show();

        // 2 button dialog
        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);

        delDialog.setTitle("Delete");
        delDialog.setIcon(R.drawable.baseline_delete_forever_24);
        delDialog.setMessage("Are you sure want to delete");

        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });

        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        delDialog.show();


    }

    // 3 button dialog. Basically used in exiting from home screen

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);

        exitDialog.setTitle("Exit");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitDialog.setMessage("Are you sure want to exit");

        // text of "no" in positive button also possible 
        exitDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"does not exit, WELCOME BACK",Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();         // for back pressed
                Toast.makeText(MainActivity.this, "Exit from the app", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Operation cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();
    }
}










