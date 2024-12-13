@test
Feature: Search vehicle valuation information

  As a user
  I would like to search a vehicle with a registration number
  So that I can check the valuation of the vehicle

  Scenario: Read the input text file and compare the vehicle search results with the output text file
    Given I have read and extracted vehicle registration numbers from "car_input_v2.txt"
    When I navigate to the "car valuation" page
    And I should be presented with "car valuation" page
    Then I feed the vehicle registration numbers extracted from "car_input_v2.txt" and compare the output with "car_output_v2.txt"