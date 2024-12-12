package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.VehicleValuationPage;
import utils.FileReaderUtil;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VehicleValuationSteps {
    private VehicleValuationPage valuationPage;
    private List<String> inputRegistrationNumbers;
    private StringBuilder outputRegistrationNumbers;
    private final String path = "src/test/resources/dataFile/";

    @Before
    public void initPage() {
        valuationPage = new VehicleValuationPage(Hooks.getDriver());
    }

    @Given("^I have read and extracted vehicle registration numbers from \"([^\"]*)\"$")
    public void i_have_read_and_extracted_vehicle_registration_numbers_from(String fileName) {

        inputRegistrationNumbers = FileReaderUtil.extractVehicleRegNumbers(path + fileName);

        System.out.println("These are the vehicle registration numbers " + inputRegistrationNumbers);
    }

    @When("^I navigate to the \"([^\"]*)\" page$")
    public void i_navigate_to_the(String pageName) {
        valuationPage.navigateTo();
    }

    @And("^I should be presented with \"([^\"]*)\" page")
    public void i_should_be_presented_with(String pageName) {
        valuationPage.assertTitleUrlHeading();
    }

    @And("^I feed the vehicle registration numbers extracted from \"([^\"]*)\"$")
    public void i_feed_the_extracted_registration_numbers_on_the(String fileName) throws InterruptedException, IOException {

        for (String regNum : inputRegistrationNumbers) {

            valuationPage.inputRegNumber(regNum);
            valuationPage.inputMileage();
            valuationPage.inputPostcode();
            valuationPage.submit();
            Thread.sleep(5000);
            valuationPage.vehicleDetails();
        }
    }

    @And("^I compare the output returned with \"([^\"]*)\"$")
    public void i_compare_the_output_returned_with(String fileName) throws IOException {

        outputRegistrationNumbers = FileReaderUtil.readOutputFile(path + fileName);

        String outputText = outputRegistrationNumbers.toString().trim();

        String inputText = valuationPage.vehicleDetails();
//                .replaceAll("\\r?\\n", " ").trim();


        if (outputText.equals(valuationPage.vehicleDetails())) {


        } else {
            System.out.println("The output text did not match with the input text");

            System.out.println(inputText);

            System.out.println(outputText);
        }

    }
}











