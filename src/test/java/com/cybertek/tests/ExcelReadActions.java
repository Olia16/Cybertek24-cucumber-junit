package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {
    String filePath = "Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
        //open the Employees.xlsx using Apache POI
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);

        //goto "data" sheet by index
        XSSFSheet dateSheet = workbook.getSheetAt(0);

        //print column names. row 0; cells 0,1,2
        System.out.println("Column names: ");
        System.out.println( dateSheet.getRow(0).getCell(0));

        System.out.println("=====================================");
        //loop and print all three column names
        for(int i = 0; i < 3; i++){
            System.out.println( dateSheet.getRow(0).getCell(i));

        }

        //find out number of rows in the worksheet   //note, method doesn't count empty row
        int rowsCount = dateSheet.getPhysicalNumberOfRows();
        System.out.println("Number of rows: " + rowsCount);

        //starts counting from zero, counts empty rows as well
        int usedRowsCount = dateSheet.getLastRowNum();
        System.out.println("Used rows count: " + usedRowsCount);

        //print all first names
        System.out.println("Print all the first names: ");
        for(int i = 1; i <= usedRowsCount; i++){
            System.out.println(dateSheet.getRow(i).getCell(0));
        }

        //loop and find "Fahima" in firstname column
        //print her last name and job title
        System.out.println("\nFahima info:");
        for(int i = 1; i <= usedRowsCount; i++){
          if(dateSheet.getRow(i).getCell(0).toString().equals("Masha")){
              System.out.println(dateSheet.getRow(i).getCell(0) + " | " + dateSheet.getRow(i).getCell(1) + " | " +
                      dateSheet.getRow(i).getCell(2));
                      break;
          }
        }



    }
}
