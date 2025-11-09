/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/*
 * Name: Eugene Makhukhule 
 * Student Number:  ST1047984
 * POE: Part 3
 * Date: 26 May 2025
 * Description: This program manages messages by storing, sending,
 * and displaying them using dialog boxes.
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author eugen
 */
public class ChatSystem {
 // Static User object to hold the registered user's information
    
    
//POE PArt 3
//Arrays to store message data
    private static final ArrayList<Message> sentMessage = new ArrayList<>();
    private static final ArrayList<Message> disregardMessages = new ArrayList<>();
    private static final ArrayList<Message> storeMessages = new ArrayList<>();
    private static final ArrayList<Message> messageHashes = new ArrayList<>();
    private static final ArrayList<Message> messageIDs = new ArrayList<>();

    public static User user;

    /**
     * Method to start the chat system by registering a new user and then logging in.
     * @return Boolean indicating if login was successful or not
     */
    public static boolean startChat() {
        // --- Registration Process ---

        // Prompt user to enter a username
        String username = JOptionPane.showInputDialog(null, "Register - Enter Username (must include an underscore and be <= 5 characters):");
        if (username == null || !Validator.checkUserName(username.trim())) {
            JOptionPane.showMessageDialog(null, "Invalid Username.\nMust include an underscore and be no more than 5 characters.");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        }

        // Prompt user to enter a password
        String password = JOptionPane.showInputDialog(null, "Register - Enter Password (must be complex: 8+ chars, upper case, digit, special char):");
        if (password == null || !Validator.checkPasswordComplexity(password.trim())) {
            JOptionPane.showMessageDialog(null, "Invalid Password.\nMust include uppercase, digit, special character and be at least 8 characters long.");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        }

        // Prompt user to enter a South African cellphone number
        String phone = JOptionPane.showInputDialog(null, "Register - Enter Cellphone Number (Format: +27XXXXXXXXX):");
        if (phone == null || !Validator.checkCellPhoneNumber(phone.trim())) {
            JOptionPane.showMessageDialog(null, "Invalid Phone Number.\nMust start with +27 and be exactly 12 characters.");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Cellphone number successfully added.");
        }

        // Prompt for first name
        String firstName = JOptionPane.showInputDialog(null, "Register - Enter First Name:");
        if (firstName == null || firstName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "First name cannot be empty.");
            return false;
        }

        // Prompt for last name
        String lastName = JOptionPane.showInputDialog(null, "Register - Enter Last Name:");
        if (lastName == null || lastName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Last name cannot be empty.");
            return false;
        }

        // Create a new User object with captured details
        user = new User(username.trim(), password.trim(), phone.trim(), firstName.trim(), lastName.trim());

        // Confirm successful registration
        JOptionPane.showMessageDialog(null, "Registration Complete!");

        // --- Login Process ---

        // Prompt for login username
        String loginUser = JOptionPane.showInputDialog(null, "Login - Enter Username:");
        if (loginUser == null) return false;

        // Prompt for login password
        String loginPass = JOptionPane.showInputDialog(null, "Login - Enter Password:");
        if (loginPass == null) return false;

        // Attempt login using the stored User object
        boolean success = user.login(loginUser.trim(), loginPass.trim());

        // Show login result
        JOptionPane.showMessageDialog(null, success ? "Login successful!" : "Login failed!");


        return success;
    }

}
