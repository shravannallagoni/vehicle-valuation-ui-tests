package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriverException;
import utils.Driver;

public class Hooks extends Driver {

    // Method to set up before each test scenario
    @Before
    public void setUp() throws Throwable {
        // Check if driver is not initialized
        if (driver == null) {
            // Initialize browser
            CreateBrowser();
        }
        // Maximize the browser window
        driver.manage().window().maximize();
        // Delete all cookies
        driver.manage().deleteAllCookies();
    }

    // Method to tear down after each test scenario
    @After
    public void tearDown(Scenario scenario) {
        // Check if scenario failed
        if (scenario.isFailed()) {
            try {
                // Print name of failed scenario
                System.out.println("Failed Scenario: " + scenario.getName());
                // Log current URL of driver
                scenario.log(driver.getCurrentUrl());
            } catch (WebDriverException e) {
                // Throw WebDriverException if unable to log URL
                throw new WebDriverException(e.getMessage());
            }
        }
        // Delete all cookies
        driver.manage().deleteAllCookies();
        // Quit the driver instance
        driver.quit();
        // Set driver to null
        driver = null;
    }

}
