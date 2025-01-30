package com.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;



public class FlightSearchSteps {

    WebDriver driver;

    @Given("I open the MakeMyTrip website")
    public void i_open_the_makemytrip_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
    }

    @When("I click on the {string} section")
    public void i_click_on_the_section(String section) {
        if (section.equals("Flights")) {
            driver.findElement(By.linkText("Flights")).click();
        }
    }

    @When("I select {string}")
    public void i_select(String tripType) {
        if (tripType.equals("Round Trip")) {
            driver.findElement(By.id("roundTrip")).click(); // Assuming the id is 'roundTrip'
        }
    }

    @When("I enter {string} as the From Location")
    public void i_enter_as_the_from_location(String fromLocation) {
        driver.findElement(By.id("fromCity")).sendKeys(fromLocation);
        driver.findElement(By.xpath("//p[text()='Hyderabad, India']")).click(); // Select HYD
    }

    @When("I enter {string} as the To Location")
    public void i_enter_as_the_to_location(String toLocation) {
        driver.findElement(By.id("toCity")).sendKeys(toLocation);
        driver.findElement(By.xpath("//p[text()='Chennai, India']")).click(); // Select MAA
    }

    @When("I select a Departure Date")
    public void i_select_a_departure_date() {
        driver.findElement(By.id("departure")).click();  // Assuming the ID is 'departure'
        driver.findElement(By.xpath("//div[@aria-label='Wed, 03 Feb 2025']")).click(); // Select a date
    }

    @When("I select a Return Date")
    public void i_select_a_return_date() {
        driver.findElement(By.id("return")).click();  // Assuming the ID is 'return'
        driver.findElement(By.xpath("//div[@aria-label='Wed, 10 Feb 2025']")).click(); // Select a date
    }

    @When("I click the Search button")
    public void i_click_the_search_button() {
        driver.findElement(By.id("searchBtn")).click(); // Assuming the button ID is 'searchBtn'
    }

    @Then("I should be redirected to the search results page")
    public void i_should_be_redirected_to_the_search_results_page() {
        assertTrue(driver.getTitle().contains("Search"));
        driver.quit();
    }
}
