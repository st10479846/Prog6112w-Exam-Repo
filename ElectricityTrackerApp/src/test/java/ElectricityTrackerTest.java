/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.electricitytrackerapp.EnergyRecord;
import com.mycompany.electricitytrackerapp.UnitRecord;
import com.mycompany.electricitytrackerapp.UsageTracker;
import com.mycompany.electricitytrackerapp.UserAccount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author eugen
 */
import java.time.LocalDate;


/**
 * Test class for ElectricityTracker application.
 * Validates arrays, loops, inheritance, constructors, information hiding, and integration.
 */
public class ElectricityTrackerTest {
    
    /**
     * Tests array handling in UsageTracker.
     * Ensures that the compareMultipleMonths method works with string arrays.
     */
    @Test
    public void testArrays() {
        System.out.println("=== Testing Arrays ===");
        String[] testMonths = {"1", "2", "3"};
        UsageTracker tracker = new UsageTracker();
        
        // Compare multiple months and ensure result is not null or empty
        String result = tracker.compareMultipleMonths(2024, testMonths);
        assertNotNull(result);
        assertTrue(result.length() > 0);
        
        System.out.println("✅ Arrays requirement validated\n");
    }
    
    /**
     * Tests different loop structures: enhanced for, traditional for, and while loops.
     */
    @Test
    public void testLoops() {
        System.out.println("=== Testing Loops ===");
        UsageTracker tracker = new UsageTracker();
        
        // Add test records for loop iteration
        tracker.addRecord(new UnitRecord(LocalDate.of(2024, 1, 1), 100, 500));
        tracker.addRecord(new UnitRecord(LocalDate.of(2024, 1, 15), 150, 750));
        tracker.addRecord(new UnitRecord(LocalDate.of(2024, 2, 1), 120, 600));
        
        // Enhanced for loop over records
        System.out.println("Testing enhanced for loop:");
        int recordCount = 0;
        for (EnergyRecord record : tracker.getRecords()) {
            System.out.println("Record: " + record.getDate() + " - " + record.getUnits() + " units");
            recordCount++;
        }
        assertEquals(3, recordCount);
        
        // Traditional for loop over an array
        String[] months = {"1", "2"};
        for (String month : months) {
            System.out.println("Processing month: " + month);
        }
        
        // While loop simulation
        int counter = 0;
        while (counter < 3) {
            System.out.println("While loop iteration: " + counter);
            counter++;
        }
        assertEquals(3, counter);
        
        System.out.println("✅ Loops requirement validated\n");
    }
    
    /**
     * Tests inheritance from EnergyRecord to UnitRecord.
     * Validates that methods and instanceof checks work as expected.
     */
    @Test
    public void testInheritance() {
        System.out.println("=== Testing Inheritance ===");
        EnergyRecord electricityRecord = new UnitRecord(LocalDate.now(), 100, 500);
        
        assertEquals("Electricity Usage Record", electricityRecord.getRecordType());
        assertTrue(electricityRecord.getCostPerUnit() > 0);
        assertTrue(electricityRecord.calculateEfficiency() > 0);
        
        // Confirm instanceof relationships
        assertTrue(electricityRecord instanceof EnergyRecord);
        assertTrue(electricityRecord instanceof UnitRecord);
        
        System.out.println("Record Type: " + electricityRecord.getRecordType());
        System.out.println("Cost per Unit: R" + electricityRecord.getCostPerUnit());
        System.out.println("Efficiency: " + electricityRecord.calculateEfficiency());
        System.out.println("Is UnitRecord instance of EnergyRecord: " + (electricityRecord instanceof EnergyRecord));
        
        System.out.println("✅ Inheritance requirement validated\n");
    }
    
    /**
     * Tests constructors of UserAccount and UnitRecord.
     * Ensures objects are created correctly and getters return expected values.
     */
    @Test
    public void testConstructors() {
        System.out.println("=== Testing Constructors ===");
        UserAccount user = new UserAccount("testuser", "password", "MTR123");
        UnitRecord unitRecord = new UnitRecord(LocalDate.now(), 100, 500);
        
        assertNotNull(user);
        assertNotNull(unitRecord);
        assertEquals("testuser", user.getUsername());
        assertEquals(100, unitRecord.getUnits(), 0.001);
        
        System.out.println("✅ Constructors requirement validated\n");
    }
    
    /**
     * Tests information hiding and encapsulation in UserAccount.
     * Validates that private fields are accessed via getters and authentication works.
     */
    @Test
    public void testInformationHiding() {
        System.out.println("=== Testing Information Hiding ===");
        UserAccount user = new UserAccount("testuser", "secret", "MTR456");
        
        // Access through getters
        assertEquals("testuser", user.getUsername());
        assertEquals("MTR456", user.getMeterNumber());
        
        // Test authentication (indirect access to private password)
        assertTrue(user.authenticate("secret"));
        assertFalse(user.authenticate("wrongpassword"));
        
        System.out.println("Username: " + user.getUsername());
        System.out.println("✅ Information Hiding requirement validated\n");
    }
    
    /**
     * Integration test to check interactions between UsageTracker and UnitRecord.
     */
    @Test
    public void testIntegration() {
        System.out.println("=== Testing Integration ===");
        UsageTracker tracker = new UsageTracker();
        UnitRecord record = new UnitRecord(LocalDate.of(2024, 1, 1), 100, 500);
        tracker.addRecord(record);
        
        System.out.println("Added record: " + record.getUnits() + " units, R" + record.getCost());
        System.out.println("Total units: " + tracker.getTotalUnits());
        System.out.println("Total cost: " + tracker.getTotalCost());
        System.out.println("Record count: " + tracker.getRecords().size());
        
        // Validate tracker state
        assertEquals(1, tracker.getRecords().size());
        assertEquals(100, tracker.getTotalUnits(), 0.001);
        
        // NOTE: Ensure EnergyRecord.getCost() returns correct cost
        // If getCost() still returns units due to previous bug, this assertion may fail
        assertEquals(500, tracker.getTotalCost(), 0.001);
        
        System.out.println("✅ Integration test completed\n");
    }
}