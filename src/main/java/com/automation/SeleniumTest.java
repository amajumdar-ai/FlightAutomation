package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");  // Update with actual path

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.makemytrip.com/");
        
        driver.findElement(By.id("fromCity")).sendKeys("HYD");
        driver.findElement(By.id("toCity")).sendKeys("MAA");
        driver.findElement(By.id("departure")).click();
        
        driver.findElement(By.id("return")).click();
        
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        System.out.println(driver.getTitle());
        driver.quit();
    }
}
