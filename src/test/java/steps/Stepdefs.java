package steps;

import dataProvider.ConfigFileReader;
import helpers.HelperClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {
    LifeInsuranceQuoteQuickPage lifeInsurancePage = new LifeInsuranceQuoteQuickPage();

    @Given("Launch the browser")
    public void launchBrowser() {
        HelperClass.openPage(ConfigFileReader.getProperty("url"));
        System.out.println(ConfigFileReader.getProperty("url"));
    }

    @When("The user clicks the Life Insurance header link")
    public void theUserClicksTheLifeInsuranceLink() {
        lifeInsurancePage.clickLifeInsuranceLink();
    }

    @Then("Verify the user is navigated to the life insurance page : {string}")
    public void verifyTheUserIsNavigatedToTheLifeInsurancePage(String path) {
        lifeInsurancePage.verifyUrlPath(path);
    }

    @When("The user clicks the Check Our Prices hero button")
    public void theUserClicksTheCheckOurPricesHeroButton() {
        lifeInsurancePage.clickCheckOurPricesHeroButton();
    }

    @Then("The user is navigated to the the Life insurance quick quote page : {string}")
    public void theUserIsNavigatedToTheTheLifeInsuranceQuickQuotePage(String path) {
        lifeInsurancePage.verifyUrlPath(path);
    }

    @Then("Verify the following headers is displayed on the life insurance quick quote form")
    public void verifyTheFollowingHeadersIsDisplayedOnTheLifeInsuranceQuickQuoteForm(DataTable headers) {
        lifeInsurancePage.verifyQuickQuoteFormHeadersDisplayed(headers);
    }

    @And("The user clicks the GET INSTANT ESTIMATE button")
    public void theUserClicksTheGetInstantEstimateButton() {
        lifeInsurancePage.clickInstantEstimateButton();
    }

    @And("The user captures a age value of : {string}")
    public void theUserCapturesAgeValueOf(String age) {
        lifeInsurancePage.inputAgeValue(age);
    }

    @Then("Verify the error message {string} is displayed")
    public void verifyTheErrorMessageIsDisplayed(String error) {
        lifeInsurancePage.verifyErrorMessageDisplayed(error);
    }

    @And("The user selects the gender value of : {string}")
    public void theUserSelectsTheGenderValueOf(String gender) {
        lifeInsurancePage.clickGenderButton(gender);
    }

    @Then("Verify the list {string} contains values")
    public void verifyTheQuestionOptionsContainsValues(String field, DataTable values) {
        lifeInsurancePage.verifyListValues(field,values);
    }

    @And("The user selects the qualification value of : {string}")
    public void theUserSelectsTheQualificationValueOf(String qualification) throws InterruptedException {
        lifeInsurancePage.selectQualification(qualification);
    }

    @And("The user selects the occupation value of : {string}")
    public void theUserSelectsTheOccupationValueOf(String occupation) {
        lifeInsurancePage.selectOccupation(occupation);
    }

    @And("The user inputs a Monthly Salary value of : {string}")
    public void theUserInputsAMonthlySalaryValueOf(String amount) {
        lifeInsurancePage.inputMonthlySalary(amount);
    }

    @And("The user selects a Use of Tobacco or Nicotine products value of : {string}")
    public void theUserSelectsAUseOfTobaccoOrNicotineProductsValueOf(String tobaccoNicotineOption) {
        lifeInsurancePage.clickTobaccoUsageOption(tobaccoNicotineOption);
    }

    @And("Verify the My Advisor's code is field is {string}")
    public void verifyTheMyAdvisorSCodeIsFieldIs(String displayedNotDisplayed) {
        lifeInsurancePage.verifyAdvisorCodeFieldDisplayedNotDisplayed(displayedNotDisplayed);
    }

    @And("Click the I am being assisted by an advisor button")
    public void clickTheIAmBeingAssistedByAnAdvisorButton() {
        lifeInsurancePage.clickIamAssistedByAnAdvisorButton();
    }

    @Then("Verify hero image is displayed")
    public void verifyHeroImageIsDisplayed() {
        lifeInsurancePage.verifyHeroImageDisplayed();
    }
}