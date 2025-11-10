
package com.mycompany.mainapp;

/**
 *
 * @author eugen
 */
public class ProductData {

    // Sales for 2 years and 3 products per year
    private int[][] sales = {
            {300, 150, 700}, // Year 1 -> (Microphone, Speakers, Mixer)
            {250, 200, 600}  // Year 2
    };

    public int[][] getSalesData() {
        return sales;
    }
}

