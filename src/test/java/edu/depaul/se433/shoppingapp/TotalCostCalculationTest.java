/* Varun Nair
    SE 333
    Final Project
 */

package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// In this file there will be Strong Normal Tests, Weak Robust Tests and Boundary Tests
public class TotalCostCalculationTest {

    //Strong Normal Tests


    //No Tax w/ Standard Shipping
    @Test
    @DisplayName("Cart Below $50 w/No Tax w/Standard Shipping")
    void below50NoTaxStandard(){
        double cost = TotalCostCalculator.calculate(10.00, "WA", ShippingType.STANDARD);
        assertEquals(20.00, cost);
    }

    @Test
    @DisplayName("Cart Above $50 w/No Tax w/Standard Shipping")
    void above50NoTaxStandard(){
        double cost = TotalCostCalculator.calculate(60.00, "WA", ShippingType.STANDARD);
        assertEquals(60.00, cost);
    }

    //No Tax w/Next Day Shipping (+$25)

    @Test
    @DisplayName("Cart Below $50 w/No Tax w/Next Day Shipping")
    void below50NoTaxNextDay(){
        double cost = TotalCostCalculator.calculate(10.00, "WA", ShippingType.NEXT_DAY);
        assertEquals(35.00, cost);
    }

    @Test
    @DisplayName("Cart Above $50 w/No Tax w/Next Day Shipping")
    void above50NoTaxNextDay(){
        double cost = TotalCostCalculator.calculate(60.00, "WA", ShippingType.NEXT_DAY);
        assertEquals(85.00, cost);
    }

    //Tax w/ Standard Shipping
    @Test
    @DisplayName("Cart Below $50 w/Tax w/Standard Shipping")
    void below50TaxStandard(){
        double cost = TotalCostCalculator.calculate(10.00, "IL", ShippingType.STANDARD);
        assertEquals(21.60, cost);
    }

    @Test
    @DisplayName("Cart Above $50 w/Tax w/Standard Shipping")
    void above50TaxStandard() {
        double cost = TotalCostCalculator.calculate(60.00, "IL", ShippingType.STANDARD);
        assertEquals(63.60, cost);
    }

    //Tax w/Next Day Shipping (+$25)
        @Test
        @DisplayName("Cart Below $50 w/Tax w/Next Day Shipping")
        void below50TaxNextDay(){
            double cost = TotalCostCalculator.calculate(10.00, "IL", ShippingType.NEXT_DAY);
            assertEquals(35.60, cost);
        }

        @Test
        @DisplayName("Cart Above $50 w/Tax w/Next Day Shipping")
        void above50TaxNextDay(){
            double cost = TotalCostCalculator.calculate(60.00, "IL", ShippingType.NEXT_DAY);
            assertEquals(88.60, cost);
        }

    //Weak Robust Tests
    @Test
    @DisplayName("Negative Price")
    void negativePrice() {
        try {
            double cost = TotalCostCalculator.calculate(-1.00, "IL", ShippingType.STANDARD);
            fail();
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    @Test
    @DisplayName("Shipping not described")
    void shippingTypeNull() {
        try {
            double cost = TotalCostCalculator.calculate(20.00, "IL", null);
            fail();
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    @Test
    @DisplayName("State not given to calculate tax")
    void unableToCalculateTax() {
        try {
            double cost = TotalCostCalculator.calculate(100.00, null, ShippingType.STANDARD);
            fail();
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    //Boundary Tests

    @Test
    @DisplayName("Below $50 for free shipping")
    void below50FreeShipping() {
        double cost = TotalCostCalculator.calculate(50.00, "IL", ShippingType.STANDARD);
        assertEquals(60.00, cost);
    }

    @Test
    @DisplayName("Above $50 for free shipping")
    void above50FreeShipping() {
        double cost = TotalCostCalculator.calculate(50.01, "IL", ShippingType.STANDARD);
        assertEquals(50.01, cost);
    }

    @Test
    @DisplayName("Invalid Price for Purchase")
    void invalidPriceForPurchase() {
        try {
            double costt = TotalCostCalculator.calculate(0.00, "IL", ShippingType.STANDARD);
            fail();
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    @Test
    @DisplayName("Valid Price for purchase")
    void validPriceForPurchase() {
        double cost = TotalCostCalculator.calculate(0.01, "IL", ShippingType.STANDARD);
        assertEquals(10.01, cost);
    }

}
