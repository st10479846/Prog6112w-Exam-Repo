
package com.mycompany.mainapp;

/**
 *
 * @author eugen
 */
public class ProductSales implements IProductSales {

    private ProductData data;
    private final int SALES_LIMIT = 500;

    public ProductSales(ProductData data) {
        this.data = data;
    }

    @Override
    public int[][] GetProductSales() {
        return data.getSalesData();
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : GetProductSales()) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = GetProductSales().length * GetProductSales()[0].length;
        return (double) total / count;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : GetProductSales()) {
            for (int sale : year) {
                if (sale > SALES_LIMIT) count++;
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : GetProductSales()) {
            for (int sale : year) {
                if (sale < SALES_LIMIT) count++;
            }
        }
        return count;
    }

    @Override
    public int GetYearsProcessed() {
        return GetProductSales().length;
    }
}

