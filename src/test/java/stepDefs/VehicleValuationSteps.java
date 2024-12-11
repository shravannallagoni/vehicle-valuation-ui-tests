package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.VehicleValuationPage;
import utils.ConfigFileReader;

import java.util.List;


public class VehicleValuationSteps {

    private WebDriver driver;
    VehicleValuationPage vehicleValuationPage = new VehicleValuationPage(driver);

    private List<String> registrationNumbers;
    private final String path = "src/test/resources/dataFile/";
    
    @Given("^I have extracted vehicle registration numbers from \"([^\"]*)\"$")
        public void i_have_extracted_vehicle_registration_numbers_from (String filePath) {
        registrationNumbers = ConfigFileReader.extractVehicleRegNumbers(path + filePath);
        System.out.println("These are the vehicle registration numbers " + registrationNumbers);
    }

    @When("^I navigate to the \"([^\"]*)\" page$")
         public void i_navigate_to_the (String pageName) {
        vehicleValuationPage.navigateTo();
    }

    @And("^I should be presented with \"([^\"]*)\" page")
    public void i_should_be_presented_with (String pageName) {
    }

    @And("^I feed the extracted registration numbers on the \"([^\"]*)\" page$")
        public void i_feed_the_extracted_registration_numbers_on_the(String pageName) {

        for (String regNum: registrationNumbers) {
        }
    }

}
