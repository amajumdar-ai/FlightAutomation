package com.automation;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelFile {

    public static void main(String[] args) {
        // Create a new workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee Data");

        // Create the header row with column names
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("EMP No");
        headerRow.createCell(1).setCellValue("EMP Name");
        headerRow.createCell(2).setCellValue("EMP Designation");
        headerRow.createCell(3).setCellValue("EMP Salary");
        headerRow.createCell(4).setCellValue("EMP Department");

        // Add sample employee data rows
        Object[][] employeeData = {
            {1, "John Doe", "Manager", 75000, "HR"},
            {2, "Jane Smith", "Developer", 60000, "IT"},
            {3, "Sam Wilson", "Analyst", 50000, "Finance"},
            {4, "Lucy Brown", "Designer", 65000, "Design"},
            {5, "Paul Green", "Developer", 70000, "IT"}
        };

        // Write the data to the sheet
        int rowNum = 1;
        for (Object[] employee : employeeData) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue((int) employee[0]);
            row.createCell(1).setCellValue((String) employee[1]);
            row.createCell(2).setCellValue((String) employee[2]);
            row.createCell(3).setCellValue((int) employee[3]);
            row.createCell(4).setCellValue((String) employee[4]);
        }

        // Write the output to the EmployeeData.xlsx file in the resources folder
        try (FileOutputStream fileOut = new FileOutputStream("src/test/resources/EmployeeData.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing the Excel file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


