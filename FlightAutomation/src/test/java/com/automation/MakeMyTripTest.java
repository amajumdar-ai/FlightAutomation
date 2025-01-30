package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;


public class MakeMyTripTest {
    public static void main(String[] args) {
        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        
        // Set Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.makemytrip.com/");
        
        // Click on 'Flights' and select ROUND TRIP
        driver.findElement(By.xpath("//span[text()='From']/preceding::input")).sendKeys("HYD");
        driver.findElement(By.xpath("//span[text()='To']/preceding::input")).sendKeys("MAA");
        
        // Select departure and return dates (Assuming the date is selected by default for simplicity)
        
        // Click on 'Search' Button
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        
        // Wait for Search Page to load
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Search"));

        
        // Verify the title of the page
        if (driver.getTitle().contains("Search")) {
            System.out.println("Search Page Loaded Successfully.");
        } else {
            System.out.println("Search Page Failed to Load.");
        }
        
        // Close the browser
        driver.quit();
    }
}

