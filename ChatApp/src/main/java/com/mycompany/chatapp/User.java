/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/*
 * Name: Eugene Makhukhule 
 * Student Number:  ST1047984
 * POE: Part 2
 * Date: 26 May 2025
 * Description: This program manages messages by storing, sending,
 * and displaying them using dialog boxes.
 */
public class User {
    // User's personal details and credentials stored as private final fields
    private final String username;
    private final String password;
    private final String phone;
    private final String firstName;
    private final String lastName;
    private boolean isLoggedIn;

    /**
     * Constructor to initialize a new User object with all necessary details.
     * @param username
     * @param password
     * @param phone
     * @param firstName
     * @param lastName
     */
    public User(String username, String password, String phone, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isLoggedIn = false; //Default to not logged in PO# Part 3
    }

       //POE Part 3 Editi
        //Constant for consistent messagin
    private static final String WELCOME_PREFIX = "Welcome Back!,";
    private static final String NAME_SEPARATOR = " ";
    //End of code Edit POE 3----------------------
    /**
     * Validates the login credentials entered by the user.
     * @param username
     * @return 
     */
    public boolean login(String username, String password) {
         if (this.username.equals(username) && this.password.equals(password)) {
            this.isLoggedIn = true;
            return true;
        } else {
            this.isLoggedIn = false;
            return false;
        }
    }

    /**
     * Returns a welcome or error message based on login result.
     * @param isLoggedIn
     * @return 
     */
    //POE Part 3 Code Edit
    public String returnLoginStatus() {
         if (isLoggedIn) {
            return "Welcome Back!, " + firstName + " " + lastName;
        } else {
            return "Please log in.";
        }
      }      
    
    //----End---------

    // Optional: Getters for accessing user info if needed
   public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
    public void setLoggedIn(boolean loggedIn) {
       this.isLoggedIn = loggedIn;
    }
}

