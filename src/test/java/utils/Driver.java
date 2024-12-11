package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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
            case "firefox" -> createFirefoxDriver();
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
        // Check if running headless mode
        if (System.getProperty("headLess").equals("true")) {
            options.addArguments("--headless=new");
        }
        // Setup ChromeDriver and return instance
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        return driver;
    }

    // Method to create Firefox WebDriver instance
    private static WebDriver createFirefoxDriver() {
        // Configure Firefox profile
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("acceptSslCerts", true);
        // Configure Firefox options
        FirefoxOptions firefoxoptions = new FirefoxOptions();
        firefoxoptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        firefoxoptions.setProfile(profile);
        // Check if running headless mode
        if (System.getProperty("headLess").equals("true")) {
            firefoxoptions.addArguments("--headless=new");
        }
        // Setup GeckoDriver and return instance
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxoptions);
        return driver;
    }
}