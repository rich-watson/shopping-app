package edu.depaul.se433.shoppingapp;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/shoppingcart.feature")
public class CucumberTestRunner {

}
