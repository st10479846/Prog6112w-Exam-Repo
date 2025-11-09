/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalinfo;

/**
 *
 * @author eugen
 */
public class Validator {
    
    // Check if a string is not empty
    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Check if the input is a valid age (integer, >0)
    public static boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age > 0 && age < 120; // basic validation
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Check if the email format is valid
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    // Check if phone number is numeric and 10 digits (example for South Africa)
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }
    
}
