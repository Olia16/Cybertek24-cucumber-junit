package com.cybertek.step_definitions;

import com.cybertek.pages.MultipleWindowsPage;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Set;

public class MultipleWindowsStepDef {
    MultipleWindowsPage windowsPage = new MultipleWindowsPage();

    @Given("User is on ToolsQa page")
    public void user_is_on_tools_qa_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("multiplewindows"));
        Assert.assertEquals("ToolsQA", Driver.getDriver().getTitle());

    }
    @When("User clicks on New Tab button")
    public void user_clicks_on_new_tab_button() {
        windowsPage.tabButton.click();
        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String>openedTabs = Driver.getDriver().getWindowHandles();
        for(String eachTab : openedTabs){
            if(eachTab.equals(currentWindow)){
                continue;
            }
            Driver.getDriver().switchTo().window(eachTab);
        }

    }
    @Then("User should see {string} message on the new tab")
    public void user_should_see_message_on_the_new_tab(String string) {


    }


    @When("User clicks on New Window button")
    public void user_clicks_on_new_window_button() {

    }
    @Then("User should see \"This is a sample page\"message on the new window")
    public void user_should_see_this_is_a_sample_page_message_on_the_new_window() {

    }

    @Given("User clicks on New Window Message")
    public void user_clicks_on_new_window_message() {

    }
    @Then("User should see New Window with a message {string}")
    public void user_should_see_new_window_with_a_message(String string) {

    }
}
