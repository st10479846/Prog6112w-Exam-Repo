
package com.mycompany.mainapp;

/**
 *
 * @author eugen
 */
public interface IProductSales {

    int[][] GetProductSales();
    int GetTotalSales();
    double GetAverageSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetYearsProcessed();
}
