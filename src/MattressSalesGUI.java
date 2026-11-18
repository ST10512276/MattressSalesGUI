/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class MattressSalesGUI extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public MattressSalesGUI() {

        setTitle("Product App");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        JLabel lblCustomer = new JLabel("Customer Name:");
        JLabel lblProduct = new JLabel("Select Product:");
        JLabel lblPrice = new JLabel("Enter Price:");

        txtCustomerName = new JTextField(20);
        txtPrice = new JTextField(20);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);

        btnProcess = new JButton("PROCESS");

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 20));

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(lblCustomer);
        panel.add(txtCustomerName);

        panel.add(lblProduct);
        panel.add(cmbProduct);

        panel.add(lblPrice);
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);

        btnProcess.addActionListener(e -> processSale());
        processItem.addActionListener(e -> processSale());

        clearItem.addActionListener(e -> clearForm());

        // Close the application
        exitItem.addActionListener(e -> System.exit(0));
    }

    // Process the customer's product sale
    private void processSale() {

        try {

            String customerName = txtCustomerName.getText();
            String productName = cmbProduct.getSelectedItem().toString();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calculation =
                    new ProductCalculations(price);

            double vat = calculation.GetVat();
            double commission = calculation.GetCommission();
            double total = calculation.GetTotal();

            String result = "Customer Name: " + customerName
                    + "\nProduct: " + productName
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(this, result);

            // Save the sale details in data.txt
            FileWriter writer = new FileWriter("data.txt", true);

            writer.write("************************\n");
            writer.write(result + "\n");
            writer.close();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Please enter a valid product price.");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this,
                    "Error saving the data.");

        }
    }

    // Clear the form and reset the product selection
    private void clearForm() {

        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {

        new MattressSalesGUI().setVisible(true);

    }
}