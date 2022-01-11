package com.cybertek.pages;

import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MockarooPage {

    public MockarooPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "num_rows")
    public WebElement numbersOfRowsField;

    @FindBy(id = "mui-component-select-file_format")
    public WebElement format;

    @FindBy(xpath = "//li[.='Excel']")
    public WebElement excelOption;



    public void changeRows(int num){
        BrowserUtils.scrollDown(500);
        numbersOfRowsField.sendKeys(Keys.DELETE);
        numbersOfRowsField.sendKeys(num + "");
    }

    public void selectExcelFormat() {
      format.click();
      excelOption.click();
    }
}
