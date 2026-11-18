/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class ProductCalculations implements IProductCalculations {

    private double price;

    // Store the product price for the calculations
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculate 15% VAT on the product price
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    // Calculate 5% commission on the product price
    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    // Add the price, VAT and commission together
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}