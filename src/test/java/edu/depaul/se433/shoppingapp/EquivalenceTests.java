package edu.depaul.se433.shoppingapp;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.depaul.se433.shoppingapp.TotalCostCalculator.calculate;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;


public class EquivalenceTests {

  /* Weak Robust Test */


  private static Stream<Arguments> provideArgsForWeakRobustValid() {

    return Stream.of(

        Arguments.of(36.50, calculate(25, "IL", ShippingType.STANDARD)),
        Arguments.of(125, calculate(100, "FL", ShippingType.NEXT_DAY))

    );
  }

  @ParameterizedTest()
  @MethodSource("provideArgsForWeakRobustValid")
  void weakRobustValidTest(double expected, double actual) {

    assertEquals(expected, actual);

  }


  private static Stream<Arguments> provideArgsForWeakRobustInvalid() {

    return Stream.of(

        Arguments.of(new Exception(), new String[]{"-5", "IL"}, ShippingType.STANDARD),
        Arguments.of(new Exception(), new String[]{"25", null}, ShippingType.NEXT_DAY),
        Arguments.of(new NullPointerException(), new String[]{"100", "FL"}, null)

    );
  }

  @ParameterizedTest()
  @MethodSource("provideArgsForWeakRobustInvalid")
  void weakRobustInvalidTest(Exception expected, String[] actual, ShippingType shipping) {

    assertThrows(expected.getClass(),
        () -> calculate(Double.parseDouble(actual[0]), actual[1], shipping),
        "Args: " + actual[0] + " " + actual[1] + " " + shipping.toString());

  }



  private static Stream<Arguments> provideArgsForStrongRobust() {

    return Stream.of(

        Arguments.of(36.50, calculate(25, "IL", ShippingType.STANDARD)),
        Arguments.of(35, calculate(25, "FL", ShippingType.STANDARD)),
        Arguments.of(51.50, calculate(25, "IL", ShippingType.NEXT_DAY)),
        Arguments.of(50, calculate(25, "FL", ShippingType.NEXT_DAY)),
        Arguments.of(106, calculate(100, "IL", ShippingType.STANDARD)),
        Arguments.of(100, calculate(100, "FL", ShippingType.STANDARD)),
        Arguments.of(131, calculate(100, "IL", ShippingType.NEXT_DAY)),
        Arguments.of(125, calculate(100, "FL", ShippingType.NEXT_DAY))

    );
  }

  @ParameterizedTest()
  @MethodSource("provideArgsForStrongRobust")
  void strongRobustTest(double expected, double actual) {

    assertEquals(expected, actual);

  }


}
