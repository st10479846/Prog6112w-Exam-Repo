/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.sumandaverage.ProductSales;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author eugen
 */
import org.junit.jupiter.api.Test;

public class ProductSalesTest {

    int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
    };

    ProductSales sales = new ProductSales();

    @Test
    void CalculateTotalSales_ReturnsTotalSales() {
        int expected = 300 + 150 + 700 + 250 + 200 + 600;
        assertEquals(expected, sales.TotalSales(productSales));
    }

    @Test
    void AverageSales_ReturnsAverageProductSales() {
        double expected = (300 + 150 + 700 + 250 + 200 + 600) / 6.0;
        assertEquals(expected, sales.AverageSales(productSales));
    }

    @Test
    void MaxSale_ReturnsMaximumValue() {
        assertEquals(700, sales.MaxSale(productSales));
    }

    @Test
    void MinSale_ReturnsMinimumValue() {
        assertEquals(150, sales.MinSale(productSales));
    }
}

