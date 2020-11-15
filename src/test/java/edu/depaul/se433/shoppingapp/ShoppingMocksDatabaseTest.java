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
    }

    @Test
    @DisplayName("Calculation Of Purchase W/ No Tax & No Shipping")
    void purchaseWithNoTaxAndShipping(){
        PurchaseDBO mockPurchase = mock(PurchaseDBO.class);
        PurchaseAgent mockAgent = new PurchaseAgent(mockPurchase);
        ArrayList<Purchase> purchasesList = new ArrayList<>();
    }
}
