/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalinfo;

/**
 *
 * @author eugen
 */
public class Person {
    
     private String name;
     private String surname;
     private int age;
     private String email;
     private String phone;

    public Person(String name, String surname, int age, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Surname: " + surname + "\n" +
               "Age: " + age + "\n" +
               "Email: " + email + "\n" +
               "Phone: " + phone;
    }
    
}
