package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPage {

    public MultipleWindowsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "tabButton")
    public WebElement tabButton;


}
