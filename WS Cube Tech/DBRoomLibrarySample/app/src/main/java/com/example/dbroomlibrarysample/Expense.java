package com.example.dbroomlibrarysample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

// Define this class as a Room entity representing a table named "expense" in the database
@Entity(tableName = "expense")
public class Expense {
    // Primary key for the table, set to auto-generate a unique value for each new entry
    @PrimaryKey(autoGenerate = true)
    private int id;

    // Column in the table to store the expense title
    @ColumnInfo(name = "title")
    private String title;

    // Column in the table to store the expense amount
    @ColumnInfo(name = "amount")
    private String amount;

    // Constructor with all fields (used when the id is already known)
    Expense(int id, String title, String amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    // Constructor without id (used when id is generated automatically by Room)
    @Ignore
    Expense(String title, String amount) {
        this.title = title;
        this.amount = amount;
    }

    // Getter for the id field
    public int getId() {
        return id;
    }

    // Setter for the id field
    public void setId(int id) {
        this.id = id;
    }

    // Getter for the title field
    public String getTitle() {
        return title;
    }

    // Setter for the title field
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the amount field
    public String getAmount() {
        return amount;
    }

    // Setter for the amount field
    public void setAmount(String amount) {
        this.amount = amount;
    }
}