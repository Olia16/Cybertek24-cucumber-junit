package com.cybertek.step_definitions;

import com.cybertek.pages.PercentageCalculationsPage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class PercentageCalculationStepDef {

    @Given("User is on the percentage calculator page")
    public void user_is_on_the_percentage_calculator_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("percentage.url"));
        Assert.assertEquals("Percentage Calculator", Driver.getDriver().getTitle());
    }

    @Then("User should see following calculations:")
    public void user_should_see_following_calculations(Map<Integer,Integer> valuesMap) {
        System.out.println(valuesMap);
        PercentageCalculationsPage calculationsPage = new PercentageCalculationsPage();
        calculationsPage.inputPercentageField.sendKeys("5");

        for(Integer inputKey : valuesMap.keySet()){
            calculationsPage.inputNumberField.clear();
            calculationsPage.inputNumberField.sendKeys(inputKey + "" + Keys.ENTER );
            BrowserUtils.sleep(1);


            System.out.println("Input Value: " + inputKey);
            System.out.println("Expected 5% value: " + valuesMap.get(inputKey) );
            System.out.println("Actual 5% calculated value: " + calculationsPage.resultValue.getAttribute("value"));
            System.out.println("--------------------------");

            //assert that expected value matches actual
            Assert.assertEquals(valuesMap.get(inputKey) , Integer.valueOf(calculationsPage.resultValue.getAttribute("value")));



        }


    }
}
