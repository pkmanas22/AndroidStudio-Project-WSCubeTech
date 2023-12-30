package com.example.kotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*

**Variable Declaration:
val name: String = "John"       // Immutable (read-only) variable
var age: Int = 25           // Mutable variable


**Function Definition:
fun greet(name: String): String {
    return "Hello, $name!"
}

fun square(x: Int) = x * x          // Simplified syntax for single-expression functions

**UI Element Initialization (XML and Kotlin):
val textView = findViewById<TextView>(R.id.textView)        // Inside your Activity's onCreate method


**Setting Text and Handling Click Events:
textView.text = "Hello, Kotlin!"            // Inside your Activity's onCreate method

textView.setOnClickListener {           // Handling click events
    textView.text = "Clicked!"
}


**Conditional Statements:
val number = 10
if (number > 5) {
    println("Number is greater than 5")
} else {
    println("Number is not greater than 5")
}


**Looping:
for (i in 1..5) {
    println(i)  // Prints 1, 2, 3, 4, 5
}

val numbers = listOf(1, 2, 3, 4, 5)
for (num in numbers) {
    println(num)
}


**Collections and Mapping:
val fruits = listOf("Apple", "Banana", "Orange")
val upperCaseFruits = fruits.map { it.toUpperCase() }
println(upperCaseFruits)  // Prints [APPLE, BANANA, ORANGE]


**Nullable Types and Safe Calls:
val nullableName: String? = null
val length = nullableName?.length // Safe call
println("Name length: $length")


**Classes and Objects:
class Person(val name: String, val age: Int)

val person = Person("Alice", 30)
println("${person.name} is ${person.age} years old")
*/
