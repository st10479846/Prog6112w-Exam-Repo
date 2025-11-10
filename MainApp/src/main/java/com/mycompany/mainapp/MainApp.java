/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapp;

/**
 *
 * @author eugen
 */

   public class MainApp {
    public static void main(String[] args) {
        ProductData data = new ProductData();
        ProductSales sales = new ProductSales(data);
        javax.swing.SwingUtilities.invokeLater(() -> {
            ProductGUI gui = new ProductGUI(sales);
            gui.setVisible(true);
        });
    }
}