package edu.depaul.se433;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.depaul.se433.shoppingapp.ShippingType;
import edu.depaul.se433.shoppingapp.TotalCostCalculator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class MyStepdefs {

  private String shipping = "";
  private String state = "";
  private double cost;

  @Given("The state was {string}")
  public void theStateWas(String arg0) {
    state = arg0;
  }


  @And("the item cost was {int} dollars")
  public void theItemCostWasDollars(int arg0) {
    cost = arg0;
  }


  @And("The shipping type was {string}")
  public void theShippingTypeWas(String arg0) {
    shipping = arg0;
  }

  @Then("the total cost is {int} dollars")
  public void theTotalCostIsDollars(int expectedCost) {
    ShippingType shippingType;
    if (shipping.equals("standard")) {
      shippingType = ShippingType.STANDARD;
    } else {
      shippingType = ShippingType.NEXT_DAY;
    }
    assertEquals(expectedCost, TotalCostCalculator.calculate(cost, state, shippingType));


  }


  @Given("The purchased state was {string}")
  public void thePurchasedStateWas(String arg0) {
    state = arg0;
  }


  @And("the cost was {int} dollars")
  public void theCostWasDollars(int arg0) {
    cost = arg0;
  }

  @And("the shipping type was selected as {string}")
  public void theShippingTypeWasSelectedAs(String arg0) {
    shipping = arg0;
  }

  @Then("the total cost is {double} dollars")
  public void theTotalCostIsDollars(double expectedCost) {

    ShippingType shippingType;
    if (shipping.equals("standard")) {
      shippingType = ShippingType.STANDARD;
    } else {
      shippingType = ShippingType.NEXT_DAY;
    }
    assertEquals(expectedCost, TotalCostCalculator.calculate(cost, state, shippingType));
  }


  @Given("The item was purchased in the state of {string}")
  public void theItemWasPurchasedInTheStateOf(String arg0) {
    state = arg0;
  }

  @And("item's cost was {int} dollars")
  public void itemSCostWasDollars(int arg0) {
    cost = arg0;
  }

  @And("shipping type selected was {string}")
  public void shippingTypeSelectedWas(String arg0) {
    shipping = arg0;
  }

  @Then("the total cost due is {int} dollars")
  public void theTotalCostDueIsDollars(int expectedCost) {

    ShippingType shippingType;
    if (shipping.equals("standard")) {
      shippingType = ShippingType.STANDARD;
    } else {
      shippingType = ShippingType.NEXT_DAY;
    }
    assertEquals(expectedCost, TotalCostCalculator.calculate(cost, state, shippingType));

  }
}


