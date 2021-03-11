Feature: Shopping purchase with  total cost calculation
  Scenario: Shopper purchased a book for 10 dollars in non taxed state with standard shipping
    Given The state was "FL"
    And the item cost was 10 dollars
    And The shipping type was "standard"
    Then the total cost is 20 dollars


   Scenario: Shopper purchases a shirt for 10 dollars in a taxed state with next day shipping
     Given The purchased state was "IL"
     And the cost was 20 dollars
     And the shipping type was selected as "next day"
     Then the total cost is 46.20 dollars



    Scenario: Shopper purchases a desk for 50 dollars in a taxed state with standard shipping
      Given The item was purchased in the state of "IL"
      And item's cost was 50 dollars
      And shipping type selected was "standard"
      Then the total cost due is 63 dollars
