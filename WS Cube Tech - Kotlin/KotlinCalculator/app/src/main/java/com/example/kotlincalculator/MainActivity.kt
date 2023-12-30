package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlincalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener for the calculator button
        binding.calcuButton.setOnClickListener {
            // Check if all input fields are non-empty
            if (binding.num1.text.toString() != "" && binding.num2.text.toString() != "" && binding.operator.text.toString() != "") {
                // Extract input values and operator
                val n1 = binding.num1.text.toString().toInt()
                val n2 = binding.num2.text.toString().toInt()
                val op = binding.operator.text.toString()[0]

                // Perform calculation based on operator
                when (op) {
                    '+' -> binding.result.text = "$n1 + $n2 = ${n1 + n2}"
                    '-' -> binding.result.text = "$n1 - $n2 = ${n1 - n2}"
                    '*' -> binding.result.text = "$n1 * $n2 = ${n1 * n2}"
                    '/' -> {
                        // Check for division by zero
                        if (n2 != 0)
                            binding.result.text = "$n1 / $n2 = ${n1 / n2}"
                        else
                            binding.result.text = "Error can't divide by zero(0)"
                    }
                    else -> binding.result.text = "Please enter valid operator"
                }
            } else {
                // Display an error message if any field is blank
                Toast.makeText(this, "Error! Can't leave blank", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
