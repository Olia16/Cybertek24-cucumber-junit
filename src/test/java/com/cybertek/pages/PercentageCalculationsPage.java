package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PercentageCalculationsPage {

    public PercentageCalculationsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@size='3']")
    public WebElement inputPercentageField;

    @FindBy(xpath = "//input[@size='7']")
    public WebElement inputNumberField;

    @FindBy(xpath = "(//input[@type='submit'])[1]")
    public WebElement calculateButton;

    @FindBy(xpath = "//input[@size='6']")
    public WebElement resultValue;

}
