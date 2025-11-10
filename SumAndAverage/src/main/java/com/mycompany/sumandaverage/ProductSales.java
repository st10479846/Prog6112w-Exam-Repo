/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sumandaverage;

/**
 *
 * @author eugen
 */

   
    // Class that implements the IProduct interface and performs all sales calculations
public class ProductSales implements IProduct {

    @Override
    public int TotalSales(int[][] productSales) {
        // Variable to store the total sales value
        int total = 0;

        // Loop through each year
        for (int[] year : productSales) {
            // Loop through each quarter in the year
            for (int quarter : year) {
                // Add each quarter's sales to the total
                total += quarter;
            }
        }
        // Return the calculated total sales
        return total;
    }

    @Override
    public double AverageSales(int[][] productSales) {
        // Variable to store the sum of all sales
        int total = 0;

        // Variable to count the number of sales entries
        int count = 0;

        // Loop through each year
        for (int[] year : productSales) {
            // Loop through each quarter
            for (int quarter : year) {
                total += quarter;  // Add value to total
                count++;           // Increase count
            }
        }

        // Calculate and return the average
        return (double) total / count;
    }

    @Override
    public int MaxSale(int[][] productSales) {
        // Assume first element is the maximum
        int max = productSales[0][0];

        // Loop through all sales values
        for (int[] year : productSales) {
            for (int quarter : year) {
                // Update max if higher value is found
                if (quarter > max)
                    max = quarter;
            }
        }
        // Return the highest sales value
        return max;
    }

    @Override
    public int MinSale(int[][] productSales) {
        // Assume first element is the minimum
        int min = productSales[0][0];

        // Loop through all sales values
        for (int[] year : productSales) {
            for (int quarter : year) {
                // Update min if lower value is found
                if (quarter < min)
                    min = quarter;
            }
        }
        // Return the lowest sales value
        return min;
    }
}


