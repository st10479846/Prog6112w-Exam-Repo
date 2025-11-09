/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.personalinfo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author eugen
 */
public class PersonalInfo {
    
        private static List<Person> submissions = new ArrayList<>();

    public static void main(String[] args) {
        
        // Create the main frame
        JFrame window = new JFrame("Personal Information Form");
        window.setSize(400, 350);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        
        // ----- LABELS AND TEXT FIELDS -----
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(40, 30, 100, 25);
        window.add(lblName);
        JTextField txtName = new JTextField();
        txtName.setBounds(150, 30, 180, 25);
        window.add(txtName);

        JLabel lblSurname = new JLabel("Surname:");
        lblSurname.setBounds(40, 70, 100, 25);
        window.add(lblSurname);
        JTextField txtSurname = new JTextField();
        txtSurname.setBounds(150, 70, 180, 25);
        window.add(txtSurname);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(40, 110, 100, 25);
        window.add(lblAge);
        JTextField txtAge = new JTextField();
        txtAge.setBounds(150, 110, 180, 25);
        window.add(txtAge);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40, 150, 100, 25);
        window.add(lblEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(150, 150, 180, 25);
        window.add(txtEmail);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(40, 190, 100, 25);
        window.add(lblPhone);
        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(150, 190, 180, 25);
        window.add(txtPhone);

        // ----- BUTTONS -----
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(70, 240, 100, 30);
        window.add(btnSubmit);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(210, 240, 100, 30);
        window.add(btnClear);

        // ----- ACTIONS -----
        // Submit button: Collect and display information
                  btnSubmit.addActionListener(e -> {
                    String name = txtName.getText();
                    String surname = txtSurname.getText();
                    String ageStr = txtAge.getText();
                    String email = txtEmail.getText();
                    String phone = txtPhone.getText();

                // Validation
                 if (!Validator.isNotEmpty(name)) {
                      JOptionPane.showMessageDialog(window, "Name is required");
                       return;
                }
                if (!Validator.isNotEmpty(surname)) {
                       JOptionPane.showMessageDialog(window, "Surname is required");
                      return;
                  }
                 if (!Validator.isValidAge(ageStr)) {
                        JOptionPane.showMessageDialog(window, "Enter a valid age");
                        return;
                }
                 if (!Validator.isValidEmail(email)) {
                        JOptionPane.showMessageDialog(window, "Enter a valid email");
                       return;
                 }
                  if (!Validator.isValidPhone(phone)) {
                         JOptionPane.showMessageDialog(window, "Enter a valid 10-digit phone number");
                          return;
                 }

             int age = Integer.parseInt(ageStr);

         // Store valid submission
             Person person = new Person(name, surname, age, email, phone);
             submissions.add(person);

                 JOptionPane.showMessageDialog(window, "Submission successful:\n" + person);

                 // Clear fields
                  txtName.setText("");
                 txtSurname.setText("");
                  txtAge.setText("");
                  txtEmail.setText("");
                  txtPhone.setText("");
});

        // Center and show window
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}