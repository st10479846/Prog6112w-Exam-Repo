/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sumandaverage;

/**
 *
 * @author eugen
 */
// Main application class that displays the product sales report

public class SumAndAverage {

    public static void main(String[] args) {
         // Product sales data for 2 years (each year has 3 quarters)
        // Two-dimensional array storing product sales for 2 years
        // Each inner array represents the 3 quarters of a specific year
        int[][] productSales = {
                {300, 150, 700}, // Sales for Year 1 (Q1, Q2, Q3)
                {250, 200, 600}  // Sales for Year 2 (Q1, Q2, Q3)
        };

        // Create an object of the ProductSales class to access the calculation methods
        ProductSales sales = new ProductSales();

        // Calculate the total sales for both years
        int total = sales.TotalSales(productSales);

        // Calculate the average product sales
        double avg = sales.AverageSales(productSales);

        // Find the highest sale value in the dataset
        int max = sales.MaxSale(productSales);

        // Find the lowest sale value in the dataset
        int min = sales.MinSale(productSales);

        // Display the product sales report on the console
        System.out.println("===== PRODUCT SALES REPORT =====");
        System.out.println("Total Sales: " + total);
        System.out.println("Average Sales: " + avg);
        System.out.println("Maximum Sale: " + max);
        System.out.println("Minimum Sale: " + min);
    }
}
