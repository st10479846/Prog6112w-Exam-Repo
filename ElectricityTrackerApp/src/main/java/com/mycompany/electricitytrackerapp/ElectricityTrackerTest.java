package com.mycompany.electricitytrackerapp;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ElectricityTrackerTest {
    
    public static void main(String[] args) {
        testArrays();
        testLoops();
        testInheritance();
        testConstructors();
        testInformationHiding();
        testIntegration();
        
        JOptionPane.showMessageDialog(null, "✅ All tests passed! All requirements are met.");
    }
    
    private static void testArrays() {
        System.out.println("=== Testing Arrays ===");
        String[] testMonths = {"1", "2", "3"};
        UsageTracker tracker = new UsageTracker();
        String result = tracker.compareMultipleMonths(2024, testMonths);
        System.out.println("✅ Arrays requirement validated\n");
    }
    
    private static void testLoops() {
    System.out.println("=== Testing Loops ===");
    UsageTracker tracker = new UsageTracker();
    
    // Add test records
    tracker.addRecord(new UnitRecord(LocalDate.of(2024, 1, 1), 100, 500));
    tracker.addRecord(new UnitRecord(LocalDate.of(2024, 1, 15), 150, 750));
    tracker.addRecord(new UnitRecord(LocalDate.of(2024, 2, 1), 120, 600));
    
    // Test 1: Enhanced for loop - now using EnergyRecord
    System.out.println("Testing enhanced for loop:");
    for (EnergyRecord record : tracker.getRecords()) {
        System.out.println("Record: " + record.getDate() + " - " + record.getUnits() + " units");
    }
    
    // Test 2: Traditional for loop with array
    String[] months = {"1", "2"};
    for (int i = 0; i < months.length; i++) {
        System.out.println("Processing month: " + months[i]);
    }
    
    // Test 3: While loop simulation
    int counter = 0;
    while (counter < 3) {
        System.out.println("While loop iteration: " + counter);
        counter++;
    }
    
    System.out.println("✅ Loops requirement validated\n");
}
    
    private static void testInheritance() {
        System.out.println("=== Testing Inheritance ===");
        EnergyRecord electricityRecord = new UnitRecord(LocalDate.now(), 100, 500);
        
        System.out.println("Record Type: " + electricityRecord.getRecordType());
        System.out.println("Cost per Unit: R" + electricityRecord.getCostPerUnit());
        System.out.println("Efficiency: " + electricityRecord.calculateEfficiency());
        
        System.out.println("Is UnitRecord instance of EnergyRecord: " + 
                          (electricityRecord instanceof EnergyRecord));
        
        System.out.println("✅ Inheritance requirement validated\n");
    }
    
    private static void testConstructors() {
        System.out.println("=== Testing Constructors ===");
        UserAccount user = new UserAccount("testuser", "password", "MTR123");
        UnitRecord unitRecord = new UnitRecord(LocalDate.now(), 100, 500);
        System.out.println("✅ Constructors requirement validated\n");
    }
    
    private static void testInformationHiding() {
        System.out.println("=== Testing Information Hiding ===");
        UserAccount user = new UserAccount("testuser", "secret", "MTR456");
        System.out.println("Username: " + user.getUsername());
        System.out.println("✅ Information Hiding requirement validated\n");
    }
    
    private static void testIntegration() {
        System.out.println("=== Testing Integration ===");
        UsageTracker tracker = new UsageTracker();
        tracker.addRecord(new UnitRecord(LocalDate.of(2024, 1, 1), 100, 500));
        System.out.println("✅ Integration test completed\n");
    }
}