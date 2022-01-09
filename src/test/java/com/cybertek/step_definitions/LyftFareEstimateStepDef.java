package com.cybertek.step_definitions;

import com.cybertek.pages.LyftEstimatePage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LyftFareEstimateStepDef {
    LyftEstimatePage lyftEstimatePage = new LyftEstimatePage();

    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("lyft.url"));
        Assert.assertEquals( "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft",Driver.getDriver().getTitle());

    }
    @And("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String pickupLocation) {
        lyftEstimatePage.enterPickUpLocation(pickupLocation);

    }
    @And("User enters {string} to drop-off address")
    public void user_enters_to_drop_address(String DropOffLocation) {
        lyftEstimatePage.enterDropOffLocation(DropOffLocation + Keys.ENTER );
    }
    @And("User clicks on get estimate button")
    public void user_clicks_on_get_estimate_button() {
        lyftEstimatePage.getEstimateButton.click();
        BrowserUtils.sleep(1);
        lyftEstimatePage.getEstimateButton.click();
    }
    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(lyftEstimatePage.rideTypesHeader.isDisplayed());
        System.out.println("Lyft estimated price: "+ lyftEstimatePage.lyftPrice.getText());

    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        Assert.assertTrue(lyftEstimatePage.errorMsg.isDisplayed());
    }
}
