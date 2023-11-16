package com.alice.phoneBook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {

    // File path for the phone book file
    public static final String PHONE_BOOK_FILE_PATH = "C:\\Users\\alice\\eclipse-workspace\\phone-application\\phonebook.txt";
    // Scanner for user input
    public static Scanner sc = null;

    public static void main(String[] args) {

        // Initialize the scanner
        sc = new Scanner(System.in);

        // Get user inputs for contact information
        String userLastName = getUserInput("Entrez un nom de famille : ");
        String userFirstName = getUserInput("Entrez un prénom : ");
        String userPhoneNumber = getUserInput("Entrez un numéro de téléphone : ");

        // Create a new Contact object with the user inputs
        Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);

        // Get or create the phone book file
        File phoneBookFile = getOrCreatePhoneBookFile(PHONE_BOOK_FILE_PATH);
        // Append the new contact to the phone book file
        appendContactToPhoneBook(phoneBookFile, newContact);

        // Close the scanner
        sc.close();
    }

    // Method to get user input
    //nextLine is a method in the Scanner class in Java, commonly used for reading a line of input from the user
    public static String getUserInput(String userRequest) {

        System.out.println(userRequest);
        return sc.nextLine(); 
    }

    // Method to get or create the phone book file
    public static File getOrCreatePhoneBookFile(String phoneBookFilePath) {

        File phoneBookFile = new File(phoneBookFilePath);

        if (phoneBookFile.exists()) {
            return phoneBookFile;
        }

        try {
            // If the file doesn't exist, create a new one
            phoneBookFile.createNewFile();
            System.out.println("Le contact a bien été créé (" + phoneBookFilePath + ")");
            return phoneBookFile;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Method to add a contact to the phone book file
    public static void appendContactToPhoneBook(File phoneBookFile, Contact newContact) {

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true))) {

            // Append the contact information to the file
            fileWriter.append(newContact.toString());
            fileWriter.append(System.lineSeparator());

            System.out.println("Contact ajouté");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
