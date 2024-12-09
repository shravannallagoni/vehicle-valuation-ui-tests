package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver driver = createBrowser();

    protected static WebDriver createBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
    }
}
