package com.example.recyclerviewexample;

public class ContactModel {
    int img;            // variable to hold the image resource ID if it's inside the drawable folder
    String name, number;    // variables to hold the name and phone number of the contact

    // Constructor to create a ContactModel object with an image, name, and phone number
    public ContactModel(int image, String name, String number){
        this.name = name;       // set the name variable to the name parameter passed to the constructor
        this.img = image;       // set the img variable to the image parameter passed to the constructor
        this.number = number;   // set the number variable to the number parameter passed to the constructor
    }

    // Constructor to create a ContactModel object with just a name and phone number (no image)
    public ContactModel(String name, String number){
        this.name = name;       // set the name variable to the name parameter passed to the constructor
        this.number = number;   // set the number variable to the number parameter passed to the constructor
    }
}
