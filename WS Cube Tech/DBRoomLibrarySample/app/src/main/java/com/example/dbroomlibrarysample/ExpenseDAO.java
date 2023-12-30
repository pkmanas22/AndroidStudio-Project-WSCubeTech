package com.example.dbroomlibrarysample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDAO {
    // Data Access Object (DAO) interface to interact with the "expense" table

    // Query to retrieve all expenses from the "expense" table
    @Query("SELECT * FROM expense")
    List<Expense> getAllExpense();

    // Insert an expense into the "expense" table
    @Insert
    void addTnx(Expense expense);

    // Update an existing expense in the "expense" table
    @Update
    void updateTnx(Expense expense);

    // Delete an expense from the "expense" table
    @Delete
    void deleteTnx(Expense expense);
}