package com.mycompany.electricitytrackerapp;

import com.mycompany.electricitytrackerapp.UserAccount;
import com.mycompany.electricitytrackerapp.EnergyRecord;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Month;

public class ElectricityTrackerApp {

    // Stores the currently logged-in user
    private static UserAccount currentUser;

    // UsageTracker instance to manage energy usage records
    private static UsageTracker usageTracker = new UsageTracker();
    
    public static void main(String[] args) {
        // Prompt the user to either login or register before using the app
        currentUser = loginOrRegister();
        
        // Main menu loop - keeps running until user exits
        while (true) {
            // Menu options for the user
            String[] options = {
                "1. Add new record",
                "2. View all records",
                "3. Compare one month to previous",
                "4. Compare custom month groups",
                "5. View Total Units and Spending",
                "6. Exit"
            };

            // Show menu dialog
            String selection = (String) JOptionPane.showInputDialog(null,
                    "--- Electricity Usage Tracker ---",
                    "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            // Exit condition when "Exit" is chosen or dialog is closed
            if (selection == null || selection.equals(options[5])) {
                System.exit(0);
            }

            // Handle user selection
            switch (selection) {
                
                // CASE 1: Add a new electricity record
                case "1. Add new record" ->  {
                    // Get date input
                    String dateStr = JOptionPane.showInputDialog("Enter date (yyyy-mm-dd):");
                    LocalDate date = LocalDate.parse(dateStr);

                    // Get units purchased
                    double units = Double.parseDouble(JOptionPane.showInputDialog("Enter units purchased:"));
                    
                    // Get cost of units
                    double cost = Double.parseDouble(JOptionPane.showInputDialog("Enter total cost in Rand:"));

                    // Add the record to the tracker
                    usageTracker.addRecord(new UnitRecord(date, units, cost));
                    JOptionPane.showMessageDialog(null, "Record added successfully.");
                }

                // CASE 2: View all records entered so far
                case "2. View all records" ->  {
                    StringBuilder output = new StringBuilder("All Records:\n");

                    // Loop through all records and append to display
                    for (EnergyRecord r : usageTracker.getRecords()) {
                        output.append(String.format(
                            "Date: %s | Units: %.2f | Cost: R%.2f | Rate: R%.2f/unit\n",
                            r.getDate(), r.getUnits(), r.getCost(), r.getCostPerUnit()
                        ));
                    }
                    
                    // Show the compiled record list
                    JOptionPane.showMessageDialog(null, output.toString());
                }

                // CASE 3: Compare one month's usage to the previous month
                case "3. Compare one month to previous" ->  {
                    int year = Integer.parseInt(JOptionPane.showInputDialog("Enter year (e.g., 2025):"));
                    int month = Integer.parseInt(JOptionPane.showInputDialog("Enter month (1–12):"));

                    // Generate comparison report
                    String result = usageTracker.getMonthlyComparison(year, Month.of(month));
                    JOptionPane.showMessageDialog(null, result);
                }

                // CASE 4: Compare multiple custom months
                case "4. Compare custom month groups" ->  {
                    try {
                        // Prompt for comma-separated list of months
                        String inputMonths = JOptionPane.showInputDialog("Enter months to compare (comma-separated, e.g., 1,2,3):");
                        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter year for all months:"));

                        // Split input into array for processing
                        String[] monthArray = inputMonths.split(",");

                        // Generate and display comparison report
                        String result = usageTracker.compareMultipleMonths(year, monthArray);
                        JOptionPane.showMessageDialog(null, result);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }
                }

                // CASE 5: Display total units and total money spent
                case "5. View Total Units and Spending" ->  {
                    double totalUnits = usageTracker.getTotalUnits();
                    double totalCost = usageTracker.getTotalCost();

                    // Format output summary
                    String message = String.format(
                        "Total Units Used: %.2f\nTotal Money Spent: R%.2f",
                        totalUnits, totalCost
                    );
                    JOptionPane.showMessageDialog(null, message);
                }

                // Default case for invalid menu selection
                default -> JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }

    /**
     * Handles user login or registration process.
     * 
     * @return Logged-in UserAccount object
     */
    public static UserAccount loginOrRegister() {
        while (true) {
            // Options for login or register
            String[] options = {"Login", "Register"};
            
            // Display dialog
            int choice = JOptionPane.showOptionDialog(null,
                    "Welcome! Please log in or register.",
                    "Login/Register",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if (choice == 0) { 
                // --- LOGIN FLOW ---
                String username = JOptionPane.showInputDialog("Enter username:");
                String password = JOptionPane.showInputDialog("Enter password:");

                // Validate user credentials
                if (currentUser != null && currentUser.getUsername().equals(username)
                        && currentUser.authenticate(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    return currentUser; // Return the logged-in user
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Try again.");
                }

            } else if (choice == 1) { 
                // --- REGISTRATION FLOW ---
                String username = JOptionPane.showInputDialog("Create username:");
                String password = JOptionPane.showInputDialog("Create password:");
                String meter = JOptionPane.showInputDialog("Enter your meter number:");

                // Create new user account
                currentUser = new UserAccount(username, password, meter);
                JOptionPane.showMessageDialog(null, "Registration successful! You can now log in.");

            } else {
                // If user cancels or closes dialog, exit application
                JOptionPane.showMessageDialog(null, "Tsamaya!");
                System.exit(0);
            }
        }
    }
}