/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricitytrackerapp;


import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class UsageTracker {
    
    // Stores all energy usage records
    // Changed from List<UnitRecord> to List<EnergyRecord> to support more generic energy data
    private final List<EnergyRecord> records = new ArrayList<>();
    
    // Monthly budget for electricity usage, default is 0.0
    private double monthlyBudget = 0.0;
    
    /**
     * Adds a new energy usage record.
     * @param record An EnergyRecord object containing date, units, and cost.
     */
    public void addRecord(EnergyRecord record) {
        records.add(record);
    }

    /**
     * Returns all recorded energy data.
     * @return List of EnergyRecord objects.
     */
    public List<EnergyRecord> getRecords() {
        return records;
    }

    /**
     * Calculates the total cost for a specific month and year.
     * @param year The year to filter by.
     * @param month The month to filter by.
     * @return Total cost of electricity for that month.
     */
    public double getTotalCostForMonth(int year, Month month) {
        return records.stream()
                .filter(r -> r.getDate().getYear() == year && r.getDate().getMonth() == month)
                .mapToDouble(EnergyRecord::getCost)
                .sum();
    }

    /**
     * Compares the current month's spending with the previous month.
     * @param year The year for comparison.
     * @param currentMonth The month being compared.
     * @return A formatted string summary of the comparison.
     */
    public String getMonthlyComparison(int year, Month currentMonth) {
        Month previousMonth = currentMonth.minus(1);
        double current = getTotalCostForMonth(year, currentMonth);
        double previous = getTotalCostForMonth(year, previousMonth);

        StringBuilder result = new StringBuilder();
        result.append(String.format("Current Month: %s - R%.2f\n", currentMonth, current));
        result.append(String.format("Previous Month: %s - R%.2f\n", previousMonth, previous));

        // If there is no data for the previous month
        if (previous == 0) {
            result.append("No data for previous month.");
        } else {
            double diff = current - previous;
            double percent = (diff / previous) * 100;

            // Determine if spending increased or decreased
            if (diff > 0) {
                result.append(String.format("You spent R%.2f (%.2f%%) more this month.", diff, percent));
            } else {
                result.append(String.format("You saved R%.2f (%.2f%%) compared to last month.", -diff, -percent));
            }
        }

        return result.toString();
    }

    /**
     * Calculates the total units purchased across all records.
     * @return Total units used.
     */
    public double getTotalUnits() {
        return records.stream().mapToDouble(EnergyRecord::getUnits).sum();
    }
    
    /**
     * Calculates the total cost spent across all records.
     * @return Total cost.
     */
    public double getTotalCost() {
        return records.stream().mapToDouble(EnergyRecord::getCost).sum();
    }
    
    /**
     * Provides a summary of overall totals including
     * total units, total cost, and average cost per unit.
     * @return A formatted string report.
     */
    public String getOverallTotals() {
        double totalUnits = getTotalUnits();
        double totalCost = getTotalCost();
        double avgCostPerUnit = totalUnits > 0 ? totalCost / totalUnits : 0;

        return String.format("""
              --- Overall Totals ---
              Total Units Purchased: %.2f
              Total Money Spent: R%.2f
              Average Cost per Unit: R%.2f
              """, totalUnits, totalCost, avgCostPerUnit);
    }

    /**
     * Compares multiple custom months within the same year.
     * @param year The year to analyze.
     * @param months Array of months (as strings) to compare.
     * @return A formatted string showing units and cost per month and total.
     */
    public String compareMultipleMonths(int year, String[] months) {
        StringBuilder result = new StringBuilder("Custom Month Comparison:\n");
        double totalUnits = 0;
        double totalCost = 0;

        // Iterate over each month provided
        for (String monthStr : months) {
            try {
                int month = Integer.parseInt(monthStr.trim());
                
                // Validate month range
                if (month < 1 || month > 12) {
                    result.append("Invalid month: ").append(monthStr).append("\n");
                    continue;
                }

                Month m = Month.of(month);
                double monthUnits = 0;
                double monthCost = 0;

                // Calculate total units and cost for this month
                for (EnergyRecord r : records) {
                    if (r.getDate().getYear() == year && r.getDate().getMonth() == m) {
                        monthUnits += r.getUnits();
                        monthCost += r.getCost();
                    }
                }

                // Append month details to the result
                result.append(String.format("%s %d -> Units: %.2f, Cost: R%.2f\n", 
                        m, year, monthUnits, monthCost));

                totalUnits += monthUnits;
                totalCost += monthCost;

            } catch (NumberFormatException e) {
                // Handle invalid input that can't be parsed to an integer
                result.append("Invalid format: ").append(monthStr).append("\n");
            }
        }

        // Summary of all selected months combined
        result.append(String.format("\nTotal for Selected Months -> Units: %.2f, Cost: R%.2f", 
                totalUnits, totalCost));
        
        return result.toString();
    }

    /**
     * Sets the user's monthly electricity budget.
     * @param budget Budget amount in Rands.
     */
    public void setMonthlyBudget(double budget) {
        this.monthlyBudget = budget;
    }
    
    /**
     * Returns the currently set monthly budget.
     * @return Monthly budget amount.
     */
    public double getMonthlyBudget() {
        return monthlyBudget;
    }
    
    /**
     * Checks whether the total spending for a specific month is within the budget.
     * @param year The year to analyze.
     * @param month The month to check.
     * @return A formatted string indicating budget status.
     */
    public String checkBudgetStatusForMonth(int year, Month month) {
        double totalCost = 0;

        // Calculate total cost for the given month
        for (EnergyRecord record : records) {
            if (record.getDate().getYear() == year && record.getDate().getMonth() == month) {
                totalCost += record.getCost();
            }
        }

        // Determine if under, over, or no budget
        if (monthlyBudget == 0) {
            return "No budget set for the month.";
        } else if (totalCost > monthlyBudget) {
            return String.format("⚠ Over Budget: Spent R%.2f vs Budget R%.2f", totalCost, monthlyBudget);
        } else {
            double savings = monthlyBudget - totalCost;
            return String.format("✅ Under Budget: Spent R%.2f | Savings: R%.2f", totalCost, savings);
        } 
    }

    /**
     * Provides a more detailed budget performance report for the given month.
     * @param year The year to analyze.
     * @param month The month to analyze.
     * @return A message showing whether the user is over, under, or on budget.
     */
    public String checkBudgetPerformance(int year, Month month) {
        double totalCost = 0;

        // Calculate total cost for the given month
        for (EnergyRecord record : records) {
            if (record.getDate().getYear() == year && record.getDate().getMonth() == month) {
                totalCost += record.getCost();
            }
        }

        // If no budget has been set
        if (monthlyBudget <= 0) {
            return "⚠ No monthly budget has been set.";
        }

        // Compare spending to budget
        if (totalCost > monthlyBudget) {
            double over = totalCost - monthlyBudget;
            return String.format("🔴 Over Budget by R%.2f (Spent: R%.2f, Budget: R%.2f)", over, totalCost, monthlyBudget);
        } else if (totalCost < monthlyBudget) {
            double under = monthlyBudget - totalCost;
            return String.format("🟢 Under Budget by R%.2f (Spent: R%.2f, Budget: R%.2f)", under, totalCost, monthlyBudget);
        } else {
            return String.format("🟡 On Budget (Spent: R%.2f, Budget: R%.2f)", totalCost, monthlyBudget);
        }
    }
}