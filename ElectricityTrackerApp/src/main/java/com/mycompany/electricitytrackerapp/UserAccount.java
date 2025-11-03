/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricitytrackerapp;

/**
 *
 * @author eugen
 */
// The UserAccount class represents a user's account information.
// It stores credentials and a meter number for authentication and identification purposes.
public class UserAccount {
    
    // Private fields to ensure encapsulation
    private String username;     // Stores the username of the account
    private String password;     // Stores the account password (kept private for security)
    private String meterNumber;  // Represents the user's energy meter number
    
    // Constructor: Initializes a new UserAccount with the provided details
    public UserAccount(String username, String password, String meterNumber) {
        this.username = username;
        this.password = password;
        this.meterNumber = meterNumber;
    }
    
    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }
    
    // Getter method to retrieve the associated meter number
    public String getMeterNumber() {
        return meterNumber;
    }
    
    // Authenticates the user by comparing the provided password with the stored password
    // Returns true if the passwords match, otherwise false
    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);
    }
}
