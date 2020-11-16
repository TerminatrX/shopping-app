package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShoppingMocksDatabaseTest {
    @Test
    @DisplayName("Calculation Of Purchase W/Tax & Shipping")
    void purchaseWithTaxAndShipping(){
        PurchaseDBO mockPurchase = mock(PurchaseDBO.class);
        PurchaseAgent mockAgent = new PurchaseAgent(mockPurchase);
        ArrayList<Purchase> purchasesList = new ArrayList<>();

        Purchase purchase1 = Purchase.make("Matthew", LocalDate.of(
                2020, 11, 11), 25.00, "IL", "STANDARD");

        Purchase purchase2 = Purchase.make("Daniel", LocalDate.of(
                2020, 11, 11), 50.00, "IL", "NEXT_DAY");

        purchasesList.add(purchase1);
        purchasesList.add(purchase2);

        when(mockPurchase.getPurchases()).thenReturn(purchasesList);
        Double average = (purchase1.getCost() + purchase2.getCost()) / 2;
        assertEquals(average, mockAgent.averagePurchase());
    }

    @Test
    @DisplayName("Calculation Of Purchase W/ No Tax & No Shipping")
    void purchaseWithNoTaxAndShipping(){
        PurchaseDBO mockPurchase = mock(PurchaseDBO.class);
        PurchaseAgent mockAgent = new PurchaseAgent(mockPurchase);
        ArrayList<Purchase> purchasesList = new ArrayList<>();

        Purchase purchase1 = Purchase.make("Matthew", LocalDate.of(
                2020, 11, 11), 100.00, "AZ", "STANDARD");

        Purchase purchase2 = Purchase.make("Daniel", LocalDate.of(
                2020, 11, 11), 200.00, "AZ", "STANDARD");

        purchasesList.add(purchase1);
        purchasesList.add(purchase2);

        when(mockPurchase.getPurchases()).thenReturn(purchasesList);
        Double average = (purchase1.getCost() + purchase2.getCost()) / 2;
        assertEquals(average, mockAgent.averagePurchase());
    }
}
