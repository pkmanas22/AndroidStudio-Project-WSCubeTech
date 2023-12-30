package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of the database helper to manage the contacts table
        MyDBHelper dbHelper = new MyDBHelper(this);

        // Uncomment the following code block to add contacts to the database
        /*
        dbHelper.addContact("Manas","9999999999");
        dbHelper.addContact("Subas","8769999999");
        dbHelper.addContact("Aswini","9876999999");
        dbHelper.addContact("Jyoti","9987699999");
        dbHelper.addContact("Rama","9998769999");
        */

        // Uncomment the following code block to update a contact in the database
        /*
        ContactModel model = new ContactModel();
        model.id = 1;
        model.name = "Harry";
        model.phone_no = "1234567890";

        dbHelper.updateContact(model);
        */

        // Uncomment the following line to delete a contact from the database
        /*
        dbHelper.deleteContact(2);
        */

        // Fetch all contacts from the database and display their information
        ArrayList<ContactModel> arrContacts = dbHelper.fetchContacts();

        // Iterate through the list of contacts and log their information
        for (int i = 0; i < arrContacts.size(); i++) {
            // Uncomment the following line to delete all contacts from the database
            // dbHelper.deleteContact(i);

            // Log the name and mobile number of each contact
            Log.d("CONTACT INFO", "Name: " + arrContacts.get(i).name + ", Mob: " + arrContacts.get(i).phone_no);
        }
    }
}