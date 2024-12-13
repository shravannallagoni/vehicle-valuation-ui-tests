package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VehicleValuationPage;
import utils.FileReaderUtil;

import java.util.List;

public class VehicleValuationSteps {
    private VehicleValuationPage valuationPage;
    private List<String> inputRegistrationNumbers;
    private List<String> outputRegistrationNumbers;
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

    @Then("^I feed the vehicle registration numbers extracted from \"([^\"]*)\" and compare the output with \"([^\"]*)\"$")
    public void i_feed_the_vehicle_registration_numbers_extracted_from(String inputFile, String outputFile) throws InterruptedException {

        inputRegistrationNumbers = FileReaderUtil.extractVehicleRegNumbers(path + inputFile);

        for (String regNum : inputRegistrationNumbers) {
            valuationPage.navigateTo();
            valuationPage.inputRegNumber(regNum);
            valuationPage.inputMileage();
            valuationPage.inputPostcode();
            valuationPage.submit();
            Thread.sleep(3000);
            valuationPage.vehicleDetails();

            outputRegistrationNumbers = FileReaderUtil.readOutputFile(path + outputFile);
            String outputResult = String.join(System.lineSeparator(), outputRegistrationNumbers);

            String inputResult = valuationPage.vehicleDetails()
                    .replaceAll("\\r?\\n", " ").trim();

            if (inputResult.isEmpty()) {
                System.out.println("No actual output returned for registration number: " + regNum);
                continue;
            }

            String[] inputParts = inputResult.split("\\s+");
            String registrationNum = inputParts[inputParts.length - 1];

            String[] outputlines = outputResult.split("\\n");
            boolean matchFound = false;

            for (String line : outputlines) {
                if (line.contains(registrationNum)) {
                    String actualOutput = inputResult.replace(registrationNum, "").trim();
                    String expectedOutput = line.replace(registrationNum, "").replace(",", " ").trim();

                    if (expectedOutput.contains(actualOutput)) {
                        System.out.println("The expected output matches with the actual output");
                    } else {
                        System.out.println("The output text did not match with the input text");
                        System.out.println(expectedOutput);
                        System.out.println(actualOutput);
                    }
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                System.out.println("No matching output found for registration number: " + regNum);
            }
        }
    }
}












