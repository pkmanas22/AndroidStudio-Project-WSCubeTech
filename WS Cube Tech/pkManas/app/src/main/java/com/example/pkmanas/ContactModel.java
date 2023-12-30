package com.example.pkmanas;

public class ContactModel {

    // Instance variables to store name and mobile number
    String name;
    String mobNo;

    // Parameterized constructor to initialize name and mobile number
    ContactModel(String name, String mobNo){
        this.name = name;
        this.mobNo = mobNo;
    }

    // Default constructor
    ContactModel(){

    }

    // Getter method for retrieving mobile number
    public String getMobNo() {
        return mobNo;
    }

    // Setter method for setting mobile number
    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    // Getter method for retrieving name
    public String getName() {
        return name;
    }

    // Setter method for setting name
    public void setName(String name) {
        this.name = name;
    }
}
