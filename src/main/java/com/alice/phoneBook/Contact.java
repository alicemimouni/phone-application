package com.alice.phoneBook;

// Class representing a contact in a phone book
public class Contact {
    
    // Fields to store contact information
    private String lastName;
    private String firstName;
    private String phoneNumber;

    // Constructor to initialize a contact with provided information
    public Contact(String lastName, String firstName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    // Getter method for retrieving the last name
    public String getLastName() {
        return lastName;
    }

    // Setter method for updating the last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter method for retrieving the first name
    public String getFirstName() {
        return firstName;
    }

    // Setter method for updating the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for retrieving the phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter method for updating the phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override toString method to represent the contact as a string
    @Override
    public String toString() {
        // Format the contact information as "Last Name First Name Phone Number"
        return this.lastName + " " + this.firstName + " " + this.phoneNumber;
    }
}
