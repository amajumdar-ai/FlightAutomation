package com.automation;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestNGTest {
    @BeforeMethod
    public void setUp() {
        System.out.println("Launching Browser");
    }

    @Test
    public void testSearch() {
        System.out.println("Running Test");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser");
    }
}

