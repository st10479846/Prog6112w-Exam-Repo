
package com.mycompany.mainapp;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author eugen
 */

   public class ProductGUI extends JFrame {

    private JTextArea txtDisplay;
    private JLabel lblYears;
    private ProductSales sales;

    public ProductGUI(ProductSales sales) {
        this.sales = sales;

        setTitle("Product Sales Application");
        setSize(500, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtDisplay = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtDisplay);

        lblYears = new JLabel("Years Processed: ");

        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");

        btnLoad.addActionListener(e -> loadData());
        btnSave.addActionListener(e -> saveData());

        JPanel panel = new JPanel();
        panel.add(btnLoad);
        panel.add(btnSave);
        panel.add(lblYears);

        setJMenuBar(createMenu());

        add(scroll, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        fileMenu.add(exit);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem load = new JMenuItem("Load Product Data");
        JMenuItem save = new JMenuItem("Save Product Data");
        JMenuItem clear = new JMenuItem("Clear");

        load.addActionListener(e -> loadData());
        save.addActionListener(e -> saveData());
        clear.addActionListener(e -> clearData());

        toolsMenu.add(load);
        toolsMenu.add(save);
        toolsMenu.add(clear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        return menuBar;
    }

    private void loadData() {
        txtDisplay.setText("");
        int[][] s = sales.GetProductSales();

        txtDisplay.append("Sales Data:\n\n");
        for (int year = 0; year < s.length; year++) {
            txtDisplay.append("Year " + (year + 1) + ": ");
            for (int product = 0; product < s[year].length; product++) {
                txtDisplay.append(s[year][product] + " ");
            }
            txtDisplay.append("\n");
        }

        txtDisplay.append("\nTotal Sales: " + sales.GetTotalSales());
        txtDisplay.append("\nAverage Sales: " + sales.GetAverageSales());
        txtDisplay.append("\nSales Over Limit: " + sales.GetSalesOverLimit());
        txtDisplay.append("\nSales Under Limit: " + sales.GetSalesUnderLimit());

        lblYears.setText("Years Processed: " + sales.GetYearsProcessed());
    }

    private void saveData() {
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write(txtDisplay.getText());
            JOptionPane.showMessageDialog(this, "Data saved successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file");
        }
    }

    private void clearData() {
        txtDisplay.setText("");
        lblYears.setText("Years Processed: ");
    }
}

