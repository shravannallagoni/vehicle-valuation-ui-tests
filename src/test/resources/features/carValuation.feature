@test
  Feature: Process text file

    Scenario: Read and process the text file
      Given I have extracted vehicle registration numbers from "car_input_v2.txt"
      When I navigate to the "car valuation" page
#      And I should be presented with "car valuation" page
#      And I feed the extracted registration numbers on the "car valuation" page