package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContact = new ArrayList<>();   // list of contacts
    RecyclerContactAdapter adapter;    // adapter for recycler view
    FloatingActionButton btnOpenDialog;    // floating action button to open dialog
    RecyclerView recyclerContact;   // recycler view to display contacts


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect with id
        recyclerContact= findViewById(R.id.recyclerContact);

        // set layout for recycler view
        recyclerContact.setLayoutManager(new LinearLayoutManager(this));

        // for adding/updating contact
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        // set click listener on the button to open the dialog
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // create a dialog box to get input from the user
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                // get references to the EditText views and the submit button
                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNumber = dialog.findViewById(R.id.editNumber);
                Button submitBtn = dialog.findViewById(R.id.submitBtn);

                // set the heading text and button text for adding contact
                TextView heading = dialog.findViewById(R.id.heading);
                heading.setText("Add Contact");
                submitBtn.setText("Add");

                // set click listener on submit button to add the contact to the list
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";
                        // check if the name field is not empty
                        if (!editName.getText().toString().equals("")) {
                            name = editName.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "Please enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        // check if the number field is not empty
                        if (!editNumber.getText().toString().equals("")) {
                            number = editNumber.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "Please enter contact Number", Toast.LENGTH_SHORT).show();
                        }

                        // add the new contact to the list and notify the adapter
                        arrContact.add(new ContactModel(R.drawable.a,name,number));
                        adapter.notifyItemInserted(arrContact.size()-1);
                        recyclerContact.scrollToPosition(arrContact.size()-1);
                        dialog.dismiss();
                    }
                });

                dialog.show();  // show the dialog box
            }
        });

        // initialize the list of contacts with sample data

//        ContactModel model = new ContactModel(R.drawable.a, "Manas", "9876543210");
//        arrContact.add(model);           // it needs object of contact class model of type

        arrContact.add(new ContactModel(R.drawable.a, "A", "9876543210"));
        arrContact.add(new ContactModel(R.drawable.b, "B", "9876543222"));
        arrContact.add(new ContactModel(R.drawable.c, "C", "9876543333"));
        arrContact.add(new ContactModel(R.drawable.d, "D", "9876544444"));
        arrContact.add(new ContactModel(R.drawable.a, "E", "9876543210"));
        arrContact.add(new ContactModel(R.drawable.b, "F", "9876543222"));
        arrContact.add(new ContactModel(R.drawable.c, "G", "9876543333"));
        arrContact.add(new ContactModel(R.drawable.d, "H", "9876544444"));
        arrContact.add(new ContactModel(R.drawable.a, "I", "9876543210"));
        arrContact.add(new ContactModel(R.drawable.b, "J", "9876543222"));
        arrContact.add(new ContactModel(R.drawable.c, "K", "9876543333"));
        arrContact.add(new ContactModel(R.drawable.d, "L", "9876544444"));
        arrContact.add(new ContactModel(R.drawable.a, "M", "9876543210"));
        arrContact.add(new ContactModel(R.drawable.b, "N", "9876543222"));
        arrContact.add(new ContactModel(R.drawable.c, "O", "9876543333"));
        arrContact.add(new ContactModel(R.drawable.d, "P", "9876544444"));
//        data set completed, now time for adapter
//        Adapter set in RecyclerContactAdapter.java

        adapter = new RecyclerContactAdapter(this,arrContact);

        recyclerContact.setAdapter(adapter);

    }
}