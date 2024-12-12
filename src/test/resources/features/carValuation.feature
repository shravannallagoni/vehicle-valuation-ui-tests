@test
  Feature: Process text file

    Scenario: Read and process the text file
      Given I have read and extracted vehicle registration numbers from "car_input_v2.txt"
      When I navigate to the "car valuation" page
      And I should be presented with "car valuation" page
      And I feed the vehicle registration numbers extracted from "car_input_v2.txt"
       And I compare the output returned with "car_output_v2.txt"