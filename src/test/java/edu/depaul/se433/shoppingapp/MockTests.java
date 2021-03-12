package edu.depaul.se433.shoppingapp;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MockTests {


  @Test
  @DisplayName("Tests the averagePurchase function with integer math")
  void mockAveragePurchaseNiceMath() {

    PurchaseDBO service = mock(PurchaseDBO.class);
    String user = anyString();
    List<Purchase> purchases = new ArrayList<>();
    purchases.add(Purchase.make("Book", LocalDate.now(), 15.0, "FL", "Standard"));
    purchases.add(Purchase.make("Book2", LocalDate.now(), 15.0, "IL", "Next Day"));
    purchases.add(Purchase.make("Book2", LocalDate.now(), 15.0, "IL", "Next Day"));
    purchases.add(Purchase.make("Book4", LocalDate.now(), 15.0, "IL", "Next Day"));

    when(service.getPurchases(user)).thenReturn(purchases);

    PurchaseAgent agent = new PurchaseAgent(service);

    assertEquals(15.0, agent.averagePurchase(user));


  }

  @Test
  @DisplayName("Tests the averagePurchase function with uneven doubles")
  void mockAveragePurchaseNotNiceMath() {

    PurchaseDBO service = mock(PurchaseDBO.class);
    String user = anyString();
    List<Purchase> purchases = new ArrayList<>();
    purchases.add(Purchase.make("Book", LocalDate.now(), 15.99, "FL", "Standard"));
    purchases.add(Purchase.make("Book2", LocalDate.now(), 15.87, "IL", "Next Day"));
    purchases.add(Purchase.make("Book2", LocalDate.now(), 15.34, "IL", "Next Day"));
    purchases.add(Purchase.make("Book4", LocalDate.now(), 15.22, "IL", "Next Day"));

    when(service.getPurchases(user)).thenReturn(purchases);

    PurchaseAgent agent = new PurchaseAgent(service);

    assertEquals(15.61, agent.averagePurchase(user));


  }

  @Test
  @DisplayName("Verifies that PurchaseAgent calls the database in the save function")
  void verifyDBOSave() {

    PurchaseDBO service = mock(PurchaseDBO.class);
    Purchase purchase = Purchase.make("Book2", LocalDate.now(), 15.0, "IL", "Next Day");

    doNothing().when(service).savePurchase(purchase);

    PurchaseAgent agent = new PurchaseAgent(service);
    agent.save(purchase);

    verify(service, atLeastOnce()).savePurchase(purchase);


  }



}
