@LifeInsurance @Regression @InstantEstimate

Feature: One Spark - Life Insurance Instant Estimate

  Background: User launches the One Spark home page
    Given Launch the browser
    And The user clicks the Life Insurance header link
    And Verify the user is navigated to the life insurance page : "/life"


  Scenario Outline: Get Instant Estimate
    When The user clicks the Check Our Prices hero button
    And The user captures a age value of : "<age>"
    And The user selects the gender value of : "<gender>"
    And The user selects the qualification value of : "<qualification>"
    And The user selects the occupation value of : "<occupation>"
    And The user inputs a Monthly Salary value of : "<amount>"
    And The user selects a Use of Tobacco or Nicotine products value of : "<useOfTobaccoNicotine>"
    And The user clicks the GET INSTANT ESTIMATE button
    Then Verify the user is navigated to the life insurance page : "/life/quote/quick/estimate"
    Then Verify the Instant Estimate cover "Life Cover" value is "<lifeCoverAmount>"
    And Verify the Instant Estimate cover "Disability Cover" value is "<disabilityCoverAmount>"
    And Verify the Instant Estimate cover "Temporary Income Protection" value is "<tempIncomeProtectionAmount>"
    And Verify the Instant Estimate cover "Illness Cover" value is "<illnessCover>"

    Examples:
      | age | gender | qualification | occupation    | amount | useOfTobaccoNicotine | lifeCoverAmount | disabilityCoverAmount | tempIncomeProtectionAmount | illnessCover |
      | 65  | female | Matric        | Test engineer | 15000  | Not once             | R 933 pm        | Not Displayed         | Not Displayed              | R 1,395 pm   |
      | 18  | male   | No Matric     | Test engineer | 20000  | On a daily basis     | R 268 pm        | R 145 pm              | R 127 pm                   | R 84 pm      |
      | 30  | female | Matric        | Test engineer | 50000  | On a weekly basis    | R 107 pm        | R 109 pm              | R 268 pm                   | R 155 pm     |
      | 65  | male   | No Matric     | Test engineer | 5000   | Not once             | R 2,063 pm      | Not Displayed         | Not Displayed              | R 2,233 pm   |
      | 18  | female | Matric        | Test engineer | 1000   | On a weekly basis    | R 228 pm        | R 163 pm              | R 4 pm                     | R 62 pm      |