package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehicleValuationPage extends BasePage  {

    public VehicleValuationPage(WebDriver driver) {


        final String PageTitle = "Free car valuations - How much is my car worth? | MOTORS";

        super.driver = driver;
        super.pageTitle = PageTitle;

    }
    public void navigateTo() {
            try {
                Thread.sleep(3000);
                driver.get("https://www.cazoo.co.uk/value-my-car/");
                // wait for page to load
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(webDriver -> ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState").equals("complete"));
                String ExpectedTitle = driver.getTitle();
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.titleIs(ExpectedTitle));

                acceptCookies();

                // verify lazy loaded content
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                Boolean isLazyLoaded = (Boolean) jse.executeScript("return Array.from(document.querySelectorAll('img')).every(img => img.complete)");
                System.out.println("Lazy-loaded content loaded: " + isLazyLoaded);

                // scroll to lazy loaded content position
                WebElement lazyContent = driver.findElement(By.cssSelector(".lazy-loaded-content-selector"));
                jse.executeScript("arguments[0].scrollIntoView(true);", lazyContent);

                // wait for lazy loaded content
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOf(lazyContent));

                System.out.println("Lazy Loaded Content Successfully Displayed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void feedVehicleRegNum(String regNum) {
        driver.findElement(By.xpath("//*[@id='vyv-form']//input")).clear();
        driver.findElement(By.xpath("//*[@id='vyv-form']//input")).sendKeys(regNum);
    }

    public void submitButton() {
//        driver.findElement(By.xpath("//*[@id='vyv-form']//button")).click();
       WebElement webElement = driver.findElement(By.xpath("//*[@id='vyv-form']//button"));
//        javaScriptExecutor(webElement);
    }

}
