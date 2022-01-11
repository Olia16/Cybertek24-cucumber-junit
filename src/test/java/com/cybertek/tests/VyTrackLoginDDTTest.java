package com.cybertek.tests;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.VyTrackDashboardPage;
import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {
    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));

    }
    @After
    public void tearDown(){
       //Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {
        //open Excel book
        String filePath = "VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("data");
        System.out.println( sheet.getRow(0).getCell(1));

//   String username = "user1";
//   String password = "UserUser123";
//   String firstName = "John";
//   String lastName = "Doe";
        String firstName = "";
        String lastName = "";
        for(int i = 1; i <= sheet.getLastRowNum(); i++ ){
            String username = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            firstName = sheet.getRow(i).getCell(2).toString();
            lastName = sheet.getRow(i).getCell(3).toString();

            loginPage.login(username,password);

            System.out.println("Full name: " + dashboardPage.fullName.getText());
            String actualName = dashboardPage.fullName.getText();

            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if(actualName.contains(firstName) && actualName.contains(lastName)){
                System.out.println("Pass");
                resultCell.setCellValue("PASS");
            }else{
                System.out.println("Fail");
                resultCell.setCellValue("Fail");
            }

            dashboardPage.logout();
            BrowserUtils.sleep(1);

        }
        //save changes
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        in.close();
        out.close();







    }
}
