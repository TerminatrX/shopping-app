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
        assertEquals(15.00, cost);
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
        double cost = TotalCostCalculator.calculate(10.00, "WA", ShippingType.STANDARD);
        assertEquals(35.00, cost);
    }

    @Test
    @DisplayName("Cart Above $50 w/No Tax w/Next Day Shipping")
    void above50NoTaxNextDay(){
        double cost = TotalCostCalculator.calculate(60.00, "WA", ShippingType.STANDARD);
        assertEquals(85.00, cost);
    }

    //Tax w/ Standard Shipping

    //Tax w/Next Day Shipping (+$25)

    //Weak Robust Tests

    //Boundary Tests
}
