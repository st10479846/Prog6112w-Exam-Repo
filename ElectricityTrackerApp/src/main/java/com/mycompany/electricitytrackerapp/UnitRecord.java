/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricitytrackerapp;

import java.time.LocalDate;

// UnitRecord class extends the abstract EnergyRecord class
// Represents a specific type of energy record, in this case, electricity usage.
public class UnitRecord extends EnergyRecord {
    
    // Constructor: Initializes the UnitRecord with date, units, and cost.
    public UnitRecord(LocalDate date, double units, double cost) {
        super(date, units, cost); // Calls the superclass constructor
    }
    
    @Override
    public String getRecordType() {
        // Returns the type of record, specifically for electricity usage
        return "Electricity Usage Record";
    }
    
    @Override
    public double calculateEfficiency() {
        // Calculates efficiency as the reciprocal of the cost per unit
        // Higher cost per unit means lower efficiency
        return 1.0 / getCostPerUnit();
    }
    
    // Provides the unit rate (cost per unit)
    // This method is kept for compatibility with other parts of the system
    public double getUnitRate() {
        return getCostPerUnit();
    }
    
    /* 
     * NOTE: The following methods are inherited from the EnergyRecord class:
     * - getDate()
     * - getUnits()
     * - getCost()
     * - getCostPerUnit()
     * 
     * They do not need to be redefined here, which reduces redundancy.
     */
}