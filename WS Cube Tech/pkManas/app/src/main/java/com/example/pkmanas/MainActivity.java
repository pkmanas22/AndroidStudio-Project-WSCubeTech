package com.example.pkmanas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    EditText edtName;
    EditText edtMobNo;
    Button btnSubmit;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Messaging

        // Initialize Firebase Messaging
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();

        // Request the token for this device
        firebaseMessaging.getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    // If token retrieval failed, log an error message
                    Log.e("TokenDetails", "Token failed to receive!");
                    return;
                }

                // Get the received token from the task result
                String token = task.getResult();

                // Log the received token
                Log.d("TOKEN", token);
            }
        });


//       Real time database

//         single node data

        /*DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Copyright");

        databaseReference.setValue("Hi, this is Manas");*/

//         multiple node data

        // Initialize views
        edtName = findViewById(R.id.edtName);
        edtMobNo = findViewById(R.id.edtMobNo);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);

        // Button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String mobNo = edtMobNo.getText().toString();

                if (!name.isEmpty() && !mobNo.isEmpty()) {
                    // Initialize Firebase Database reference
                    DatabaseReference contactRef = FirebaseDatabase.getInstance().getReference("Contacts");

                    // Generate a unique key for the new contact
                    String contactId = contactRef.push().getKey();

                    // Create a ContactModel instance
                    ContactModel contactModel = new ContactModel(name, mobNo);

                    // Add the contact model to the database
                    contactRef.child(contactId).setValue(contactModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            edtName.setText("");
                            edtMobNo.setText("");
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Data added Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Data update failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

//                     Receive Data from the database
                    contactRef.child(contactId).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            ContactModel model = snapshot.getValue(ContactModel.class);
                            if (model != null) {
                                txtResult.setText("Previous Data\nName: " + model.getName() + ", Mob No.: " + model.getMobNo());
                            } else {
                                txtResult.setText("No Data Found");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(MainActivity.this, "Some error occurred", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Please fill in both Name and Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
