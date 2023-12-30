package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.IDNA;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DB_NAME = "ContactDB";

    // Database Version
    private static final int DB_VERSION = 1;

    // Table Name
    private static final String TABLE_NAME = "Contacts";

    // Column Names
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_MOB = "phone_no";

    // Constructor
    public MyDBHelper(Context context) {
        // Call the parent constructor to create or open the database
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the database table if it does not exist
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT, " + COL_MOB + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists and create a new one
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

// Method to add a new contact to the database
    public void addContact(String name, String phone_no) {
        SQLiteDatabase database = this.getWritableDatabase();

        // Create a new ContentValues object to store the contact data
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_MOB, phone_no);

        // Insert the contact data into the table
        database.insert(TABLE_NAME, null, values);
        database.close(); // Close the database connection after the operation
    }

// Method to retrieve all contacts from the database
    public ArrayList<ContactModel> fetchContacts() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Retrieve all data from the table using a Cursor
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ContactModel> arrContacts = new ArrayList<>();

        // Iterate through the cursor and create ContactModel objects for each row
        while (cursor.moveToNext()) {
            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);

            arrContacts.add(model);
        }

        cursor.close();
        db.close(); // Close the database connection after the operation
        return arrContacts;
    }

// Method to update contact details in the database
    public void updateContact(ContactModel contactModel) {
        SQLiteDatabase database = this.getWritableDatabase();

        // Create a new ContentValues object with updated contact data
        ContentValues values = new ContentValues();
        values.put(COL_MOB, contactModel.phone_no);
        values.put(COL_NAME, contactModel.name);

        // Update the contact in the table using its ID
        database.update(TABLE_NAME, values, COL_ID + " = " + contactModel.id, null);
        database.close(); // Close the database connection after the operation
    }

// Method to delete a contact from the database
    public void deleteContact(int id) {
        SQLiteDatabase database = this.getWritableDatabase();

        // Delete the contact from the table using its ID
        database.delete(TABLE_NAME, COL_ID + " = ? ", new String[]{String.valueOf(id)});
        database.close(); // Close the database connection after the operation
    }
}