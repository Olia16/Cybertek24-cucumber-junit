package com.cybertek.step_definitions;

import com.cybertek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DiceJobSearchStepDefs {

    @Given("user is on the dice homepage")
    public void user_is_on_the_dice_homepage() {
        System.out.println("User is on Dice homepage");
        Driver.getDriver().get("https://www.dice.com/");
    }

    @When("user enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {
        System.out.println("User enters java and 07013");
        WebElement inputJobTitle = Driver.getDriver().findElement(By.id("typeaheadInput"));
        inputJobTitle.sendKeys("java");
        WebElement inputZipcode = Driver.getDriver().findElement(By.id("google-location-search"));
        inputZipcode.sendKeys("07013" + Keys.ENTER);

    }

    @Then("user should see search results")
    public void user_should_see_search_results() {
        System.out.println("User should see search result");
        WebElement result = Driver.getDriver().findElement(By.id("totalJobCount"));
        System.out.println(result.getText());
    }
}
