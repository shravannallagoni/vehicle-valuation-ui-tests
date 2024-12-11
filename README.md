# vehicle-valuation-ui-tests

## To run the test suite locally please follow below steps:
1. Install apache maven on your machine as the project uses maven build.
2. Install JAVA JDK on your machine.
3. Install Selenium Java.
4. Install Cucumber Java plugin.

## Page Object Model

This project is for running behaviour driven development tests using the Page Object Model design pattern.

## Scenarios

This project has a feature file that represent pages in the service. Written using cucumber, this scenario is behaviour driven and readable
in plain english.

## Step Definition

The step definitions sit behind each step in a scenario in order to make it executable. Within each step definition is a
method/methods within a class.

## Pages

The classes are held within the pages. They are representatives of pages within the service and hold methods
based on that pages functionality.

## Execution of Tests

Using shell script file:

Before running this script change the browser and environment to the desired ("chrome" and "local") against which you wanted to run the tests

./run_regression_test.sh
