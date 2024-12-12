package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Driver {

    // Initialize WebDriver instance
    protected static WebDriver driver = CreateBrowser();

    // Method to create WebDriver instance based on browser type
    protected static WebDriver CreateBrowser() {
        // Get browser type from system properties, defaulting to "chrome"
        String browserType = System.getProperties().getProperty("browser", "chrome");
        return switch (browserType) {
            case "chrome" -> createChromeDriver();
            default -> throw new RuntimeException("Browser Type not found");
        };
    }

    // Method to create Chrome WebDriver instance
    private static WebDriver createChromeDriver() {
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        options.addArguments("--enable-javascript");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        // Setup ChromeDriver and return instance
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        return driver;
    }
}