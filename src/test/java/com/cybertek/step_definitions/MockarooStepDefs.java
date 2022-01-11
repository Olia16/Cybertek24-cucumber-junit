package com.cybertek.step_definitions;

import com.cybertek.pages.MockarooPage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MockarooStepDefs {
    MockarooPage mockarooPage = new MockarooPage();

    @Given("User is on mockaroo homepage")
    public void user_is_on_mockaroo_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("mockaroo.url"));


    }
    @Given("Number of rows is {int}")
    public void number_of_rows_is(Integer rowsCount) {
        mockarooPage.changeRows(rowsCount);

    }
    @Given("Format is Excel")
    public void format_is_excel() {
    mockarooPage.selectExcelFormat();

    }
    @When("User clicks on preview")
    public void user_clicks_on_preview() {
        mockarooPage.preview.click();

    }
    @Then("following columns should be displayed:")
    public void following_columns_should_be_displayed(List<String>expectedColumns) {
        System.out.println("Expected Columns" + expectedColumns);

        //read text of each header and store it into actualColumns
        List<String>actualColumns =  new ArrayList<>();
        for(WebElement headerName : mockarooPage.headers){
           actualColumns.add(headerName.getText());
        }
        //using method from utils to convert WebElement into String and store to list
        List<String>actualHeaderNames = BrowserUtils.getElementsText(mockarooPage.headers);
        Assert.assertEquals(expectedColumns,actualColumns);
        Assert.assertEquals(expectedColumns, actualHeaderNames);

    }
    @Then("{int} rows of data should be displayed")
    public void rows_of_data_should_be_displayed(int expectedRowsCount) {
Assert.assertEquals(expectedRowsCount,mockarooPage.tableRows.size());
    }

}
