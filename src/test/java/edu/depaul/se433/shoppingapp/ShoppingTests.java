package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;



public class ShoppingTests {

    @Test
    @DisplayName("Empty List for PurchaseAgent, ensuring correct return values from PurchaseDBO")
    void emptyListPurchaseDBO(){
        Purchase purchase = Purchase.make("Person", LocalDate.of(2020, 1, 1), 10, "IL", "STANDARD");
        assertTrue(purchase.toString().contains("date:"));
    }

    @Test
    @DisplayName("Empty List for PurchaseAgent, ensuring correct return values from PurchaseDBO")
    void emptyListPurchaseDBO2(){
        Purchase purchase = Purchase.make("Person", LocalDate.of(2020, 1, 1), 10, "IL", "STANDARD");
        assertEquals("IL", purchase.getState());

    }
}
