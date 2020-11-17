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
        PurchaseItem item = new PurchaseItem("Pen", 10, 1);
        ShoppingCart cart = new ShoppingCart();
        ShippingType shipping = ShippingType.STANDARD;
        cart.addItem(item);

        double tax = TaxCalculator.calculate(cart.cost(), "WA");
        double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
        double cost = TotalCostCalculator.calculate(cart.cost(), "WA", ShippingType.STANDARD);
        Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
        assertEquals(bill.total(), cost);
    }

    @Test
    @DisplayName("Cart Above $50 w/No Tax w/Standard Shipping")
    void above50NoTaxStandard(){
        PurchaseItem item = new PurchaseItem("Pen", 10, 6);
        ShoppingCart cart = new ShoppingCart();
        ShippingType shipping = ShippingType.STANDARD;
        cart.addItem(item);

        double tax = TaxCalculator.calculate(cart.cost(), "WA");
        double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
        double cost = TotalCostCalculator.calculate(cart.cost(), "WA", ShippingType.STANDARD);
        Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
        assertEquals(bill.total(), cost);
    }

    //No Tax w/Next Day Shipping (+$25)

    @Test
    @DisplayName("Cart Below $50 w/No Tax w/Next Day Shipping")
    void below50NoTaxNextDay(){
        PurchaseItem item = new PurchaseItem("Pen", 10, 1);
        ShoppingCart cart = new ShoppingCart();
        ShippingType shipping = ShippingType.NEXT_DAY;
        cart.addItem(item);

        double tax = TaxCalculator.calculate(cart.cost(), "WA");
        double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
        double cost = TotalCostCalculator.calculate(cart.cost(), "WA", ShippingType.NEXT_DAY);
        Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
        assertEquals(bill.total(), cost);
    }

    @Test
    @DisplayName("Cart Above $50 w/No Tax w/Next Day Shipping")
    void above50NoTaxNextDay(){
        PurchaseItem item = new PurchaseItem("Pen", 10, 6);
        ShoppingCart cart = new ShoppingCart();
        ShippingType shipping = ShippingType.NEXT_DAY;
        cart.addItem(item);

        double tax = TaxCalculator.calculate(cart.cost(), "WA");
        double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
        double cost = TotalCostCalculator.calculate(cart.cost(), "WA", ShippingType.NEXT_DAY);
        Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
        assertEquals(bill.total(), cost);
    }

    //Tax w/ Standard Shipping
    @Test
    @DisplayName("Cart Below $50 w/Tax w/Standard Shipping")
    void below50TaxStandard(){
        PurchaseItem item = new PurchaseItem("Pen", 10, 1);
        ShoppingCart cart = new ShoppingCart();
        ShippingType shipping = ShippingType.STANDARD;
        cart.addItem(item);

        double tax = TaxCalculator.calculate(cart.cost(), "IL");
        double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
        double cost = TotalCostCalculator.calculate(cart.cost(), "IL", ShippingType.STANDARD);
        Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
        assertEquals(bill.total(), cost);
    }

    @Test
    @DisplayName("Cart Above $50 w/Tax w/Standard Shipping")
    void above50TaxStandard() {
        PurchaseItem item = new PurchaseItem("Pen", 10, 6);
        ShoppingCart cart = new ShoppingCart();
        ShippingType shipping = ShippingType.STANDARD;
        cart.addItem(item);

        double tax = TaxCalculator.calculate(cart.cost(), "IL");
        double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
        double cost = TotalCostCalculator.calculate(cart.cost(), "IL", ShippingType.STANDARD);
        Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
        assertEquals(bill.total(), cost);
    }

    //Tax w/Next Day Shipping (+$25)
        @Test
        @DisplayName("Cart Below $50 w/Tax w/Next Day Shipping")
        void below50TaxNextDay(){
            PurchaseItem item = new PurchaseItem("Pen", 10, 1);
            ShoppingCart cart = new ShoppingCart();
            ShippingType shipping = ShippingType.NEXT_DAY;
            cart.addItem(item);

            double tax = TaxCalculator.calculate(cart.cost(), "IL");
            double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
            double cost = TotalCostCalculator.calculate(cart.cost(), "IL", ShippingType.NEXT_DAY);
            Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
            assertEquals(bill.total(), cost);
        }

        @Test
        @DisplayName("Cart Above $50 w/Tax w/Next Day Shipping")
        void above50TaxNextDay(){
            PurchaseItem item = new PurchaseItem("Pen", 10, 6);
            ShoppingCart cart = new ShoppingCart();
            ShippingType shipping = ShippingType.NEXT_DAY;
            cart.addItem(item);

            double tax = TaxCalculator.calculate(cart.cost(), "IL");
            double shippingCost = TotalCostCalculator.getShippingCost(shipping, cart.cost());
            double cost = TotalCostCalculator.calculate(cart.cost(), "IL", ShippingType.NEXT_DAY);
            Bill bill = new Bill(cart.cost(), shippingCost, tax, cost);
            assertEquals(bill.total(), cost);
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
            double cost = TotalCostCalculator.calculate(0.00, "IL", ShippingType.STANDARD);
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
