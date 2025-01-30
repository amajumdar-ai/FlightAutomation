package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MakeMyTripTestNG {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        
        // Set Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
        // Initialize WebDriver
        driver = new ChromeDriver(options);
    }

    @Test
    public void testFlightSearch() {
        driver.get("https://www.makemytrip.com/");
        
        // Perform actions like filling flight search form
        
        // Assert the page title
        assert driver.getTitle().contains("Search");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

