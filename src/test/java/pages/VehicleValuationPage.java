package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VehicleValuationPage extends BasePage {

    public VehicleValuationPage(WebDriver driver) {
        super(driver);
    }
    public void navigateTo() {
        driver.get("https://www.cazoo.co.uk/value-my-car/");
        acceptCookies();
    }
    public void inputRegNumber(String registrationNumbers) {
        fillInputField("//*[@id=\"vyv-form\"]/div/div[1]/div[1]/input", registrationNumbers);
    }
    public void inputMileage() {
        fillInputField("//*[@id=\"vyv-form\"]/div/div[1]/div[2]/input", "100");
    }
    public void inputPostcode() {
        fillInputField("//*[@id=\"vyv-form\"]/div/div[1]/div[3]/input", "NE11FX");
    }
    public void submit() {
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"vyv-form\"]/div/div[2]/button"));
        submitBtn.click();
    }
    public String vehicleDetails() {
        String vehdeets =
                driver.findElement(
                                By.cssSelector("#valueMyVehicle > div > section > ol > li:nth-child(2) > section > div > div.vyv__section.vyv__section--1 > div"))
                        .getText();
        return vehdeets;
    }

    private void fillInputField(String xpath, String value) {
        WebElement inputField = driver.findElement(By.xpath(xpath));
        inputField.clear();
        inputField.sendKeys(value);
    }
}

