package com.example.dbroomlibrarysample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Views
    EditText edtTitle, edtAmount;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        edtTitle = findViewById(R.id.edtTitle);
        edtAmount = findViewById(R.id.edtAmount);
        btnAdd = findViewById(R.id.btnAdd);

        // Get the instance of the database helper class
        DataBaseHelper dataBaseHelper = DataBaseHelper.getDB(this);

        // Set click listener for the "Add" button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the user input from the EditText fields
                String title = edtTitle.getText().toString();
                String amount = edtAmount.getText().toString();

                // Create an Expense object with user input
                Expense expense = new Expense(title, amount);

                // Add the Expense object to the database using the DAO (Data Access Object)
                dataBaseHelper.expenseDAO().addTnx(expense);

                // Retrieve all expenses from the database
                ArrayList<Expense> arrExpense = (ArrayList<Expense>) dataBaseHelper.expenseDAO().getAllExpense();

                // Log the retrieved data
                for (int i = 0; i < arrExpense.size(); i++) {
                    Log.d("Data", "Title: " + arrExpense.get(i).getTitle() + ", Amount: " + arrExpense.get(i).getAmount());
                }
            }
        });
    }
}