package com.cybertek.step_definitions;

import com.cybertek.pages.CalculatorPage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CalculatorStepDefs {
    CalculatorPage calculatorPage = new CalculatorPage();

    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));
        Assert.assertEquals("Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science", Driver.getDriver().getTitle());
    }
    @Given("User clicks on {string} on calculator")
    public void user_clicks_on_on_calculator(String button) {
        calculatorPage.clickOn(button);

    }
    @Then("result {string} should be displayed")
    public void result_should_be_displayed(String result) {
        System.out.println("result should be: " + result);
        String actual = calculatorPage.actualResult.getText().trim();
        Assert.assertEquals(result, actual);

    }
}
