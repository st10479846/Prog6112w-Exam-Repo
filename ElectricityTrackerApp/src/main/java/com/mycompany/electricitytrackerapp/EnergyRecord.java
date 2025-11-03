/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricitytrackerapp;

import java.time.LocalDate;

/**
 *
 * @author eugen
 */
// Base class for all energy Recoreds
   import java.time.LocalDate;

/**
 * Abstract class representing a generic energy record.
 * 
 * This serves as the base for different types of energy records
 * (e.g., electricity, gas, water). It defines common attributes and 
 * enforces implementation of specific behaviors in subclasses.
 */
public abstract class EnergyRecord {
    
    // === FIELDS ===
    // Date when the energy record was created
    protected LocalDate date;
    
    // Total energy units (e.g., kWh for electricity)
    protected double units;
    
    // Total cost associated with the units
    protected double cost;
    
    /**
     * Constructor to initialize the record's core values.
     * 
     * @param date  Date of the energy record
     * @param units Total units purchased or consumed
     * @param cost  Total monetary cost of the units
     */
    public EnergyRecord(LocalDate date, double units, double cost) {
        this.date = date;
        this.units = units;
        this.cost = cost;
    } 
    
    // === ABSTRACT METHODS ===
    // These methods must be implemented by subclasses.

    /**
     * Returns the type of the energy record.
     * Example: "Electricity", "Gas", etc.
     */
    public abstract String getRecordType();

    /**
     * Calculates the efficiency of energy usage.
     * This logic will vary depending on the type of record.
     */
    public abstract double calculateEfficiency();
    
    // === COMMON GETTERS ===
    
    /**
     * @return The date of this energy record.
     */
    public LocalDate getDate() { 
        return date;
    }

    /**
     * @return The number of units recorded.
     */
    public double getUnits() { 
        return units; 
    }

    /**
     * @return The total cost of this record.
     * 
     * NOTE: Bug fixed → Previously returned `units` by mistake.
     */
    public double getCost() { 
        return cost; 
    }

    /**
     * Calculates the cost per unit of energy.
     * 
     * @return Cost per unit or 0 if units are zero.
     */
    public double getCostPerUnit() {
        return units > 0 ? cost / units : 0;
    }
}

