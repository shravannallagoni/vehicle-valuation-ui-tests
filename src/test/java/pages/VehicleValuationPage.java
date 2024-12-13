package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VehicleValuationPage extends BasePage {

    private static final String CAZOO_URL = "https://www.cazoo.co.uk/value-my-car/";
    private static final String XPATH = "//*[@id=\"vyv-form\"]//";

    public VehicleValuationPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get(CAZOO_URL);
        acceptCookies();
    }

    public void inputRegNumber(String registrationNumbers) {
        fillInputField(XPATH + "input", registrationNumbers);
    }

    public void inputMileage() {
        fillInputField(XPATH + "div[2]/input", "100");
    }

    public void inputPostcode() {
        fillInputField(XPATH + "div[3]/input", "NE11FX");
    }

    public void submit() {
        WebElement submitBtn = driver.findElement(By.xpath(XPATH + "button"));
        submitBtn.click();
    }

    public String vehicleDetails() {
        return driver.findElement(
                        By.cssSelector("#valueMyVehicle > div > section > ol > li:nth-child(2) > section > div > div.vyv__section.vyv__section--1 > div"))
                .getText();
    }

    private void fillInputField(String xpath, String value) {
        WebElement inputField = driver.findElement(By.xpath(xpath));
        inputField.clear();
        inputField.sendKeys(value);
    }
}

