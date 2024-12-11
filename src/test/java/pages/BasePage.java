package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    protected String pageHeading = "Get a free Car Valuation";
    protected String pageTitle;

    public void acceptCookies() {
        try {
            WebElement acceptCookiesBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptCookiesBtn.click();
        } catch (TimeoutException e) {
            System.out.println("Cookies button not found or already accepted");

        }
    }
    public void assertTitleUrlHeading() {
        Assert.assertEquals("URL did not match", "https://www.cazoo.co.uk/value-my-car/", driver.getCurrentUrl());
        Assert.assertEquals("Title did not match", pageTitle, driver.getTitle());
        Assert.assertEquals("Heading did not match", pageHeading, driver.findElement(By.tagName("h1")).getText());
    }
}



