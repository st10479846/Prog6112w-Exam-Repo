/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author eugen
 */
public class Login {
    // Variables to store user credentials and names
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isLoggedIn;
    
    /**
     * Checks if the username is valid.
     * The username must contain an underscore and be 5 characters or fewer.
     * @param username The username string to check
     * @return true if valid, false otherwise
     */
    public boolean checkUsername(String username){
        return username.contains("_") && username.length() <= 5;
    }
    
    /**
     * Checks if the password meets complexity requirements.
     * Requirements:
     * - At least 8 characters long
     * - Contains at least one uppercase letter
     * - Contains at least one lowercase letter
     * - Contains at least one digit
     * - Contains at least one special character (!@#$%^&*())
     * @param password The password string to validate
     * @return true if password meets all complexity requirements, false otherwise
     */
    public boolean checkPasswordComplexity(String password){
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }
    //POE Part 3 Edit
    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
        
        //----End----
    }
}
