/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricitytrackerapp;

import java.time.LocalDate;

public class SolarRecord extends EnergyRecord {
    private double energyProduced;
    
    public SolarRecord(LocalDate date, double energyProduced, double cost) {
        super(date, energyProduced, cost);
        this.energyProduced = energyProduced;
    }
    
    @Override
    public String getRecordType() {
        return "Solar Production Record";
    }
    
    @Override
    public double calculateEfficiency() {
        return energyProduced / getCost();
    }
    
    public double getEnergyProduced() {
        return energyProduced;
    }
}