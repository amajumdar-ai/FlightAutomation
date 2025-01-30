package com.automation;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
    features = "src/test/resources/features/flight_search.feature", // Path to the feature file
    glue = "com.automation.steps", // Path to step definition classes
    plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"} // Generate reports
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
