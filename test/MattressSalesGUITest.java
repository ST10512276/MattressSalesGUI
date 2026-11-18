/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MattressSalesGUITest {

    // Test whether VAT is calculated correctly
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {

        // Arrange: Set the product price to R3500
        ProductCalculations calculation =
                new ProductCalculations(3500);

        // Act: Calculate the VAT amount
        double result = calculation.GetVat();

        // Assert: Check whether the VAT is R525
        assertEquals(525.0, result, 0.001);
    }

    // Test whether the total sale amount is calculated correctly
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {

        // Arrange: Set the product price to R3500
        ProductCalculations calculation =
                new ProductCalculations(3500);

        // Act: Calculate the total sale amount
        double result = calculation.GetTotal();

        // Assert: Check whether the total is R4200
        assertEquals(4200.0, result, 0.001);
    }
}