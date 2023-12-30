package com.example.intentpassingkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentpassingkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener for the "Next" button
        binding.btnNext.setOnClickListener {
            // Create an Intent to navigate to the SecondActivity
            val iNext = Intent(this@MainActivity, SecondActivity::class.java)

            // Start the SecondActivity
            startActivity(iNext)
        }
    }
}
