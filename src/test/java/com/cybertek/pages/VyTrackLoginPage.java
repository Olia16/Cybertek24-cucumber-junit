package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {
    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "_username")
    public WebElement usernameField;  // we can also do without findby, if the id/name matches the name
    @FindBy(name = "_password")
    public WebElement passwordField;
    @FindBy(name = "_submit")
    public WebElement submit;

   public void login(String username, String password){
       usernameField.sendKeys(username);
       passwordField.sendKeys(password);
       submit.click();
   }


}
