package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class LyftEstimatePage {

    public LyftEstimatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "fare-start")
    public WebElement pickUp;

    @FindBy(name = "fare-end")
    public WebElement dropOff;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement getEstimateButton;

    public void enterPickUpLocation(String location){
        pickUp.sendKeys(location);
    }
    public void enterDropOffLocation(String dropLocation){
        dropOff.sendKeys(dropLocation);
    }

    @FindBy(xpath = "//h3[.='RIDE TYPES']")
    public WebElement rideTypesHeader;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    public WebElement lyftPrice;

    @FindBy(xpath = "//small[.='Please select a valid location.']")
    public WebElement errorMsg;
}
