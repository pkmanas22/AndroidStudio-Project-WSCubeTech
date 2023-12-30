package com.example.recyclerviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create an ArrayList of ContactModel to hold contact data
        val arrContact = ArrayList<ContactModel>()

        // Add contact data to the ArrayList
        arrContact.add(ContactModel(R.drawable.a, "A", "9876543210"))
        arrContact.add(ContactModel(R.drawable.b, "B", "9876543222"))
        arrContact.add(ContactModel(R.drawable.c, "C", "9876543333"))
        arrContact.add(ContactModel(R.drawable.d, "D", "9876544444"))
        arrContact.add(ContactModel(R.drawable.a, "E", "9876543210"))
        arrContact.add(ContactModel(R.drawable.b, "F", "9876543222"))
        arrContact.add(ContactModel(R.drawable.c, "G", "9876543333"))
        arrContact.add(ContactModel(R.drawable.d, "H", "9876544444"))
        arrContact.add(ContactModel(R.drawable.a, "I", "9876543210"))
        arrContact.add(ContactModel(R.drawable.b, "J", "9876543222"))
        arrContact.add(ContactModel(R.drawable.c, "K", "9876543333"))
        arrContact.add(ContactModel(R.drawable.d, "L", "9876544444"))
        arrContact.add(ContactModel(R.drawable.a, "M", "9876543210"))
        arrContact.add(ContactModel(R.drawable.b, "N", "9876543222"))
        arrContact.add(ContactModel(R.drawable.c, "O", "9876543333"))

        // Set up the RecyclerView with a GridLayoutManager (3 columns)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)

        // Create an instance of RecyclerContactAdapter and pass the ArrayList
        val recyclerAdapter = RecyclerContactAdapter(this, arrContact)

        // Set the adapter for the RecyclerView
        binding.recyclerView.adapter = recyclerAdapter
    }
}
