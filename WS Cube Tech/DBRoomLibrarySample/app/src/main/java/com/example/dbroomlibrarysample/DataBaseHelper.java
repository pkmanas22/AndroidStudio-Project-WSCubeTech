package com.example.dbroomlibrarysample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Define the Room database with the Expense entity and version information
@Database(entities = Expense.class, exportSchema = false, version = 1)
public abstract class DataBaseHelper extends RoomDatabase {

    // Database Name
    private static final String DB_NAME = "expenseDB";

    // Singleton instance of the database helper
    private static DataBaseHelper instance;

    // Get a singleton instance of the database helper
    public static synchronized DataBaseHelper getDB(Context context) {
        if (instance == null) {
            // Create a Room database using the Expense class as the entity
            // and set the database name, fallback behavior, and allow queries on the main thread
            instance = Room.databaseBuilder(context, DataBaseHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    // Abstract method to access the ExpenseDAO interface
    public abstract ExpenseDAO expenseDAO();
}