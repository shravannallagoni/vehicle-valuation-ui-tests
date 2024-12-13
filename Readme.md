# Vehicle Valuation UI Automation Tests

This project automates:-

- By feeding vehicle registration numbers from an input file into a vehicle valuation (web-based) application and
- Comparing the actual output against the expected data from an output file.

## Features

- **Input File Parsing:** Extracts vehicle registration numbers from an input text file.
- **Web Automation:** Uses Selenium WebDriver to interact with the vehicle valuation web page.
- **Output Validation:** Compares actual output from the webpage with the expected data from an output text file.
- **Error Handling:** Logs mismatches and handles cases where actual output is missing.

## Prerequisites

1. **Java Development Kit (JDK):** Ensure JDK 11 or higher is installed.
2. **Maven:** For managing project dependencies.
3. **ChromeDriver:** Download the appropriate ChromeDriver version for your installed Chrome browser version.
4. **Browser:** Google Chrome should be installed.
5. **Libraries:**
    - Selenium WebDriver
    - JUnit
   
## Page Object Model
This project is for running behaviour driven development tests using the Page Object Model design pattern.

## Step Definition
The step definitions sit behind each step in a scenario in order to make it executable. Within each step definition is a method/methods within a class.

## Pages
The classes are held within the pages. They are representatives of pages within the service and hold methods based on that pages functionality.

## Setup and Execution

### 1. Clone the Repository

- git clone https://github.com/shravannallagoni/vehicle-valuation-ui-tests.git
- cd vehicle-valuation-ui-tests

### 2. Test Execution

- Use TestRunner.java file to execute the tests

## Test Steps/Work flow

1. **Read Input Data:**
    - Vehicle registration numbers are extracted from the input file using `FileReaderUtil.extractVehicleRegNumbers()`.
2. **Navigate to Valuation Page:**
    - Opens the vehicle valuation web page using `ValuationPage.navigateTo()`.
3. **Input Registration and Fetch Details:**
    - Registration numbers are entered and the resulting car details are captured.
4. **Validate Output:**
    - Compares the actual vehicle details with expected output from the output file.
    - Logs mismatches or missing data for debugging.

## Key Methods

### **FileReaderUtil**

- `extractVehicleRegNumbers(String filePath)`: Extracts registration numbers from the input file.
- `readOutputFile(String filePath)`: Reads the expected output data as a list of strings.

## Logs and Debugging

- Success message: `The expected output matches with the actual output`.
- Error message: `The output text did not match with the input text`.
- Missing data: `No actual output returned for registration number: XYZ123`.

## Future Enhancements

- Replace `Thread.sleep()` with `WebDriverWait` for better synchronization.
- Add support for more input and output file formats.
- Scenario Outline can be used as another way to feed extracted input data and compare the output data

