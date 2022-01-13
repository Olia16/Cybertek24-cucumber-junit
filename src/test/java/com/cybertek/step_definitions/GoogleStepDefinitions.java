package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleStepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @Given("User is on the google home page")
    public void user_is_on_the_google_home_page() {
        Driver.getDriver().get("https://www.google.com/");
    }
    @When("user searches for apple")
    public void user_searches_for_apple() {
        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER);

    }
    @Then("user should see apple in the title")
    public void user_should_see_apple_in_the_title() {
      String actualTitle = Driver.getDriver().getTitle();
      String expectedTitle = "apple";
      Assert.assertTrue(actualTitle.contains(expectedTitle));
    }



    @Then("User should be able to search for following:")
    public void userShouldBeAbleToSearchForFollowing(List<String>items) {
        System.out.println("items: " + items);
        //loop and search for each item

        for(String each : items){
            googleSearchPage.searchBar.sendKeys(each + Keys.ENTER);
            googleSearchPage.searchBar.clear();
        }
    }

    @Then("User should see {string}in the result")
    public void userShouldSeeInTheResult(String capitalCity) {
        System.out.println("expected Capital city name: " + capitalCity);
        Assert.assertEquals(capitalCity, googleSearchPage.searchResultCityName.getText());
    }

    @When("User searches for {string}capital")
    public void userSearchesForCapital(String countryName) {
        System.out.println("Searching for capital city of " + countryName);
        googleSearchPage.searchBar.sendKeys("What is the capital city of " + countryName + Keys.ENTER);

    }


}
