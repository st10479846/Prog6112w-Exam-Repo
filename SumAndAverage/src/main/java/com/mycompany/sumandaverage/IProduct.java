/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sumandaverage;

/**
 *
 * @author eugen
 */
public interface IProduct {
       // Calculates the total sales for all years and quarters
    int TotalSales(int[][] productSales);

    // Calculates the average sales value
    double AverageSales(int[][] productSales);

    // Returns the highest sales value from the dataset
    int MaxSale(int[][] productSales);

    // Returns the lowest sales value from the dataset
    int MinSale(int[][] productSales);
}
