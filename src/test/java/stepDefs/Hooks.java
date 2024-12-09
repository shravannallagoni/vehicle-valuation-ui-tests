package stepDefs;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import utils.Driver;

public class Hooks extends Driver {

    @Before()
    public static void setup() {
        if (driver == null) {
            createBrowser();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After()
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                System.out.println("Failed scenario: " + scenario.getName());
                String url = driver.getCurrentUrl();
                scenario.log(url);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", url);
            } catch (WebDriverException e) {
                throw new WebDriverException(e.getMessage());
            }
        }
        driver.close();
        driver.quit();
    }
}
