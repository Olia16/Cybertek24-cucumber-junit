package com.cybertek.step_definitions;

import com.cybertek.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.How;

public class Hooks {
    @Before
    public void setUpScenario(){
        System.out.println("Before setUp method is running before the scenario");

    }
    @After
    public void tearDownScenario(Scenario scenario) {
        if(scenario.isFailed()){
            //cast webdriver to TakeScreenshot interface
            byte[] image=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }

        System.out.println("AFTER - tearDown method is running after the scenario:" + scenario.getName());
        Driver.closeDriver();
    }
//    How to take screenshot of each step to save as execution evidence:
//    We can use @AfterStep annotation in Hooks class:

    //take screenshots after each step
//    @AfterStep
//    public void tearDownStep(Scenario scenario) {
//        byte[] image=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(image, "image/png", scenario.getName());
//    }

}
