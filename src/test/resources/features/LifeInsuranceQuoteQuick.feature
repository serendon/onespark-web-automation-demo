@LifeInsurance @Regression @QuoteQuick

Feature: One Spark - Life Insurance Quote Quick

  Background: User launches the One Spark home page
    Given Launch the browser
    And The user clicks the Life Insurance header link
    And Verify the user is navigated to the life insurance page : "/life"


  Scenario: User is navigated to the Life Insurance Page
    When The user clicks the Check Our Prices hero button
    Then The user is navigated to the the Life insurance quick quote page : "life/quote/quick"


  Scenario: Verify Hero Image is displayed
    When The user clicks the Check Our Prices hero button
    Then Verify hero image is displayed


  Scenario: Verify Life Insurance Quick Quote form fields is displayed
    When The user clicks the Check Our Prices hero button
    Then Verify the following headers is displayed on the life insurance quick quote form
      | I am a 30 year old | My highest qualification is: | And I work as an: | I earn a monthly salary before tax and any deductions of: | In the past 12 months I have used tobacco or nicotine products:


  Scenario: Verify list - "My highest qualification is:"
    When The user clicks the Check Our Prices hero button
    Then Verify the list "My highest qualification is:" contains values
      | No Matric | Matric | Three Year Diploma | More than a Three Year Diploma | Three Year Degree | More than a Three Year Degree | Professional |


  Scenario: Verify Options - "In the past 12 months I have used tobacco or nicotine products:"
    When The user clicks the Check Our Prices hero button
    Then Verify the list "In the past 12 months I have used tobacco or nicotine products:" contains values
      | Not once | On a daily basis | On a weekly basis | A few times here and there |


  Scenario Outline: Field Validation - "<field>"
    When The user clicks the Check Our Prices hero button
    And The user captures a age value of : "<age>"
    And The user selects the gender value of : "<gender>"
    And The user selects the qualification value of : "<qualification>"
    And The user selects the occupation value of : "<occupation>"
    And The user inputs a Monthly Salary value of : "<amount>"
    And The user selects a Use of Tobacco or Nicotine products value of : "<useOfTobaccoNicotine>"
    And The user clicks the GET INSTANT ESTIMATE button
    Then Verify the error message "<errorMessage>" is displayed

    Examples:
      | errorMessage                              | age | gender | qualification | occupation    | amount | useOfTobaccoNicotine | field                                                           |
      | Please enter your age                     |     | male   | Matric        | Test engineer | 10000  | Not once             | age                                                             |
      | You need to be at least 18                | 17  | female | Matric        | Test engineer | 10000  | Not once             | age                                                             |
      | You need to be 65 or under                | 66  | male   | No Matric     | Test engineer | 10000  | Not once             | gender                                                          |
      | Please select your gender                 | 65  |        | Matric        | Test engineer | 10000  | Not once             | gender                                                          |
      | Please select a qualification             | 18  | male   |               | Test engineer | 10000  | Not once             | My highest qualification is:                                    |
      | Please select an occupation from the list | 30  | female | Matric        |               | 10000  | Not once             | And I work as an:                                               |
      | Please enter an amount                    | 65  | male   | No Matric     | Test engineer |        | Not once             | I earn a monthly salary before tax and any deductions of:       |
      | Please select an option                   | 18  | female | Matric        | Test engineer | 10000  |                      | In the past 12 months I have used tobacco or nicotine products: |


  Scenario: Clicking "I am being assisted by an advisor" expands the Advisors Code field
    When The user clicks the Check Our Prices hero button
    And Verify the My Advisor's code is field is "Not Displayed"
    And Click the I am being assisted by an advisor button
    Then Verify the My Advisor's code is field is "Displayed"