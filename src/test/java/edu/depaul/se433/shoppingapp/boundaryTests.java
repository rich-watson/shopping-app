package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class boundaryTests {


  @Test
  @DisplayName("Tests the minimum price boundary - 1")
  void minBoundaryMinusOne() {

    double shippingPrice = TotalCostCalculator.calculate(0, "FL", ShippingType.STANDARD);
    assertEquals(10, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary - 1 with next day shipping")
  void minBoundaryMinusOneNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(0, "FL", ShippingType.NEXT_DAY);
    assertEquals(25, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary - 1 with sales tax")
  void minBoundaryMinusOneTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(0, "IL", ShippingType.STANDARD);
    assertEquals(10, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary - 1 with sales tax and next day shipping")
  void minBoundaryMinusOneTaxedNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(0, "IL", ShippingType.NEXT_DAY);
    assertEquals(25, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary")
  void minBoundary() {

    double shippingPrice = TotalCostCalculator.calculate(1, "FL", ShippingType.STANDARD);
    assertEquals(11, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary with sales tax")
  void minBoundaryTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(1, "IL", ShippingType.STANDARD);
    assertEquals(11.06, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary with next day shipping")
  void minBoundaryNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(1, "FL", ShippingType.NEXT_DAY);
    assertEquals(26, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary with next day shipping and sales tax")
  void minBoundaryNextDayTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(1, "IL", ShippingType.NEXT_DAY);
    assertEquals(26.06, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary + 1")
  void minBoundaryPlusOne() {

    double shippingPrice = TotalCostCalculator.calculate(2, "FL", ShippingType.STANDARD);
    assertEquals(12, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary + 1 with sales tax")
  void minBoundaryPlusOneTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(2, "IL", ShippingType.STANDARD);
    assertEquals(12.12, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary + 1 with next day shipping")
  void minBoundaryPlusOneNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(2, "FL", ShippingType.NEXT_DAY);
    assertEquals(27, shippingPrice);

  }

  @Test
  @DisplayName("Tests the minimum price boundary + 1 with sales tax")
  void minBoundaryPlusOneNextDayTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(2, "FL", ShippingType.NEXT_DAY);
    assertEquals(27, shippingPrice);

  }

  @Test
  @DisplayName("Tests a nominal price")
  void nominalPrice() {

    double shippingPrice = TotalCostCalculator.calculate(25, "FL", ShippingType.STANDARD);
    assertEquals(35, shippingPrice);

  }

  @Test
  @DisplayName("Tests a nominal price with sales tax")
  void nominalPriceTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(25, "IL", ShippingType.STANDARD);
    assertEquals(36.50, shippingPrice);

  }

  @Test
  @DisplayName("Tests a nominal price with next day shipping")
  void nominalPriceNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(25, "FL", ShippingType.NEXT_DAY);
    assertEquals(50, shippingPrice);

  }

  @Test
  @DisplayName("Tests a nominal price with next day shipping and sales tax")
  void nominalPriceNextDayTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(25, "IL", ShippingType.NEXT_DAY);
    assertEquals(51.50, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary minus one")
  void maxBoundaryMinusOne() {

    double shippingPrice = TotalCostCalculator.calculate(49, "FL", ShippingType.STANDARD);
    assertEquals(59, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary minus one with sales tax")
  void maxBoundaryMinusOneTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(49, "IL", ShippingType.STANDARD);
    assertEquals(61.94, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary minus one with next day shipping")
  void maxBoundaryMinusOneNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(49, "FL", ShippingType.NEXT_DAY);
    assertEquals(74, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary minus one with next day shipping and next day shipping")
  void maxBoundaryMinusOneNextDayTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(49, "IL", ShippingType.NEXT_DAY);
    assertEquals(76.94, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary")
  void maxBoundary() {

    double shippingPrice = TotalCostCalculator.calculate(50, "FL", ShippingType.STANDARD);
    assertEquals(60, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary with sales tax")
  void maxBoundaryTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(50, "IL", ShippingType.STANDARD);
    assertEquals(63, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary with next day shipping")
  void maxBoundaryNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(50, "FL", ShippingType.NEXT_DAY);
    assertEquals(75, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary with sales tax and next day shipping")
  void maxBoundaryNextDayTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(50, "IL", ShippingType.NEXT_DAY);
    assertEquals(78, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary plus one")
  void maxBoundaryPlusOne() {

    double shippingPrice = TotalCostCalculator.calculate(51, "FL", ShippingType.STANDARD);
    assertEquals(51, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary plus one with sales tax")
  void maxBoundaryPlusOneTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(51, "IL", ShippingType.STANDARD);
    assertEquals(54.06, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary plus one with next day shipping")
  void maxBoundaryPlusOneNextDay() {

    double shippingPrice = TotalCostCalculator.calculate(51, "FL", ShippingType.NEXT_DAY);
    assertEquals(76, shippingPrice);

  }

  @Test
  @DisplayName("Tests the maximum price boundary plus one with next day shipping and sales tax")
  void maxBoundaryPlusOneNextDayTaxed() {

    double shippingPrice = TotalCostCalculator.calculate(51, "IL", ShippingType.NEXT_DAY);
    assertEquals(79.06, shippingPrice);

  }

}


