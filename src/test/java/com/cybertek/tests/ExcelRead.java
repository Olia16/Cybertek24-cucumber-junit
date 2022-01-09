package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelRead {

    @Test
    public void readingFromExcel() throws IOException {
        //open excel workbook using XSSFWorkbook class
        //pass filename in the constructor
        XSSFWorkbook workbook = new XSSFWorkbook("Employees.xlsx");

        //go to worksheet, pass the worksheet name
        XSSFSheet worksheet = workbook.getSheet("data");

        System.out.println(worksheet.getRow(1).getCell(0));
        System.out.println(worksheet.getRow(3).getCell(1));
        System.out.println(worksheet.getRow(4).getCell(2));


    }
}
