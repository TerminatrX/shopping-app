package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.time.LocalDate;

public class ShoppingMocksDatabaseTest {

    @Mock
    transient PurchaseDBO mockPurchaseDBO;

    @Test
    @DisplayName("Test For Average Purchase = purchase.getCost() ")
    void testAgentAvgPurchase() throws IOException {
        PurchaseDBO purchase = new PurchaseDBO();
        PurchaseAgent testAgent = new PurchaseAgent(purchase);

        Purchase firstPurchase = new Purchase();
        firstPurchase.setCost(25);
        firstPurchase.setCustomerName("Person");
        firstPurchase.setIdNum(12314);
        firstPurchase.setPurchaseDate(LocalDate.now());
        firstPurchase.setShipping("STANDARD");
        firstPurchase.setState("IL");

        Purchase secondPurchase = new Purchase();
        secondPurchase.setCost(firstPurchase.getCost());
        secondPurchase.setCustomerName(firstPurchase.getCustomerName());
        secondPurchase.setIdNum(98765);
        secondPurchase.setPurchaseDate(firstPurchase.getPurchaseDate());
        secondPurchase.setShipping(firstPurchase.getShipping());
        secondPurchase.setState(firstPurchase.getState());

        testAgent.save(firstPurchase);
        testAgent.save(secondPurchase);

        double avgPurchase = testAgent.averagePurchase();
        double avgGetCost = (firstPurchase.getCost() + secondPurchase.getCost()) / 2;
        assertEquals(avgPurchase, avgGetCost);
    }

    @Test
    @DisplayName("Tests the Purchase toString method")
    void purchaseToStringEquivalence() throws IOException {
        PurchaseDBO purchase= new PurchaseDBO();
        PurchaseAgent testAgent = new PurchaseAgent(purchase);

        Purchase firstPurchase = new Purchase();
        firstPurchase.setCost(25);
        firstPurchase.setCustomerName("Person");
        firstPurchase.setIdNum(12314);
        firstPurchase.setPurchaseDate(LocalDate.now());
        firstPurchase.setShipping("STANDARD");
        firstPurchase.setState("IL");

        Purchase secondPurchase = new Purchase();
        secondPurchase.setCost(firstPurchase.getCost());
        secondPurchase.setCustomerName(firstPurchase.getCustomerName());
        secondPurchase.setIdNum(98765);
        secondPurchase.setPurchaseDate(firstPurchase.getPurchaseDate());
        secondPurchase.setShipping(firstPurchase.getShipping());
        secondPurchase.setState(firstPurchase.getState());

        testAgent.save(firstPurchase);
        testAgent.save(secondPurchase);
        assertEquals(firstPurchase.toString(), secondPurchase.toString(), "Purchase toString Equality");
    }

    @Test
    @DisplayName("Valid ID number Check")
    void purchaseIDEquivalence() throws IOException {
        PurchaseDBO purchase= new PurchaseDBO();
        PurchaseAgent testAgent = new PurchaseAgent(purchase);

        Purchase firstPurchase = new Purchase();
        firstPurchase.setCost(25);
        firstPurchase.setCustomerName("Person");
        firstPurchase.setIdNum(12314);
        firstPurchase.setPurchaseDate(LocalDate.now());
        firstPurchase.setShipping("STANDARD");
        firstPurchase.setState("IL");

        Purchase secondPurchase = new Purchase();
        secondPurchase.setCost(firstPurchase.getCost());
        secondPurchase.setCustomerName(firstPurchase.getCustomerName());
        secondPurchase.setIdNum(12314);
        secondPurchase.setPurchaseDate(firstPurchase.getPurchaseDate());
        secondPurchase.setShipping(firstPurchase.getShipping());
        secondPurchase.setState(firstPurchase.getState());

        testAgent.save(firstPurchase);
        testAgent.save(secondPurchase);
        assertEquals(firstPurchase.getIdNum(), secondPurchase.getIdNum(), "ID Equality");
    }
    
    @Test
    @DisplayName("Tests testAgent.save() calls mock PurchaseDBO.save()")
    void mockPurchaseDBOSave(){
        mockPurchaseDBO = mock(PurchaseDBO.class);
        PurchaseAgent testAgent = new PurchaseAgent(mockPurchaseDBO);
        Purchase purchase = new Purchase();
        purchase.setCost(25);
        purchase.setCustomerName("Person");
        purchase.setIdNum(12314);
        purchase.setPurchaseDate(LocalDate.now());
        purchase.setShipping("STANDARD");
        purchase.setState("IL");
        testAgent.save(purchase);
        verify(mockPurchaseDBO).savePurchase(purchase);
    }

    @Test
    @DisplayName("Tests testAgent.getPurchases() calls mock PurchaseDBO.getPurchases()")
    void mockPurchaseDBOGetPurchases(){
        mockPurchaseDBO = mock(PurchaseDBO.class);
        PurchaseAgent testAgent = new PurchaseAgent(mockPurchaseDBO);
        Purchase purchase = new Purchase();
        purchase.setCost(25);
        purchase.setCustomerName("Person");
        purchase.setIdNum(12314);
        purchase.setPurchaseDate(LocalDate.now());
        purchase.setShipping("STANDARD");
        purchase.setState("IL");
        testAgent.save(purchase);
        testAgent.getPurchases();
        verify(mockPurchaseDBO).getPurchases();
    }

    @Test
    @DisplayName("Checks that testAgent.avgPurchases() calls mock PurchaseDBO.getPurchases()")
    void mockPurchaseDBOAvgPurchase(){
        mockPurchaseDBO = mock(PurchaseDBO.class);
        PurchaseAgent testAgent = new PurchaseAgent(mockPurchaseDBO);
        Purchase purchase = new Purchase();
        purchase.setCost(25);
        purchase.setCustomerName("Person");
        purchase.setIdNum(12314);
        purchase.setPurchaseDate(LocalDate.now());
        purchase.setShipping("STANDARD");
        purchase.setState("IL");
        testAgent.save(purchase);

        testAgent.averagePurchase();
        verify(mockPurchaseDBO).getPurchases();
    }
}



