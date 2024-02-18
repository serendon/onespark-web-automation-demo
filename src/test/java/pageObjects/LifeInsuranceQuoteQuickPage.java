package pageObjects;

import helpers.HelperClass;
import helpers.ReUsableSteps;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LifeInsuranceQuoteQuickPage extends ReUsableSteps {
    private final WebDriver driver;

    @FindBy(xpath = "(//a[@href='/life' and text()='Life Insurance'])[1]")
    WebElement life_insurance_header_link;

    @FindBy(xpath = "//div[contains(@class,'Hero')]//a[text()='CHECK OUR PRICES']")
    WebElement check_our_prices_hero_button;

    @FindBy(xpath = "//button[@value='estimate'][text()='GET INSTANT ESTIMATE']")
    WebElement get_instant_estimate_button;

    @FindBy(xpath = "//input[@placeholder='30']/parent::div[contains(text(), 'I am a')] [text()='year old']")
    WebElement age_header;

    @FindBy(xpath = "//input[@value=''][@placeholder='30']")
    WebElement age_input;

    @FindBy(xpath = "//label[text()='Female']")
    WebElement gender_female_button;

    @FindBy(xpath = "//label[text()='Male']")
    WebElement gender_male_button;

    @FindBy(xpath = "//label[contains(., 'My highest qualification is:')]/following-sibling::div/select[contains(@class, 'SelectInput_select__')]")
    WebElement highest_qualification_dropdown;

    @FindBy(xpath = "//label[contains(., 'And I work as an:')]/following-sibling::div/div/input")
    WebElement occupation_dropdown;

    @FindBy(xpath = "(//label[contains(., 'And I work as an:')]/following-sibling::div/div/div/div/div/button)[1]")
    WebElement occupation_index_0;

    @FindBy(xpath = "//label[contains(., 'I earn a monthly salary before tax and any deductions of:')]/following-sibling::div/input")
    WebElement monthly_salary_input;

    @FindBy(xpath = "//p[contains(., 'tobacco')]/ancestor::legend/following-sibling::div//label[text()='Not once']")
    WebElement tobacco_usage_not_once_button;

    @FindBy(xpath = "//p[contains(., 'tobacco')]/ancestor::legend/following-sibling::div//label[text()='On a daily basis']")
    WebElement tobacco_usage_on_a_daily_basis_button;

    @FindBy(xpath = "//p[contains(., 'tobacco')]/ancestor::legend/following-sibling::div//label[text()='On a weekly basis']")
    WebElement tobacco_usage_on_a_weekly_basis_button;

    @FindBy(xpath = "//p[contains(., 'tobacco')]/ancestor::legend/following-sibling::div//label[text()='A few times here and there']")
    WebElement tobacco_usage_few_times_a_here_and_there_button;

    @FindBy(xpath = "//label[contains(text(), 'I am being assisted by an advisor') and ./input[@type='checkbox']]")
    WebElement advisor_assisted_checkbox;

    @FindBy(xpath = "//p[contains(., \"My Advisor's code is\")]/ancestor::label/following-sibling::div/input[@type='text']")
    WebElement advisor_code_input;

    @FindBy(xpath = "//img[@alt='happy']")
    WebElement hero_image;


    public LifeInsuranceQuoteQuickPage() {
        driver = HelperClass.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickLifeInsuranceLink() {
        life_insurance_header_link.click();
    }

    public void verifyHeroImageDisplayed() {
        Assert.assertTrue(hero_image.isDisplayed(),"Hero image not displayed");
    }

    public void verifyUrlPath(String path) {
        waitForPathLoad(driver,path);
        Assert.assertTrue(driver.getCurrentUrl().contains(path), "User is not navigated to the correct url path");
    }

    public void clickCheckOurPricesHeroButton() {
        check_our_prices_hero_button.click();
    }

    public void verifyQuickQuoteFormHeadersDisplayed(DataTable headers) {
        List<List<String>> data = headers.asLists(String.class); // Extracting data as a list of lists of Strings

        for (List<String> header : data) {
            for (String headerName : header) {
                if (headerName.toUpperCase().contains("OLD")) {
                    age_header.isDisplayed();
                } else {
                    By question = By.xpath(String.format("//*[text()='%s']", headerName));
                    Assert.assertTrue(getElement(question).isDisplayed());
                }
            }
        }
    }

    public void clickInstantEstimateButton() {
        scrollElementIntoViewAndClick(driver, get_instant_estimate_button);
    }

    public void inputAgeValue(String age) {
        age_input.click();
        age_input.sendKeys(age);
    }

    public void verifyErrorMessageDisplayed(String error) {
        By errorMessage = By.xpath(String.format("//div[contains(@class,'ErrorTooltip_container')][text()='%s']", error));
        scrollToElement(driver, errorMessage);
        Assert.assertTrue(getElement(errorMessage).isDisplayed());
    }

    public void clickGenderButton(String gender) {
        switch (gender.toUpperCase()) {
            case "MALE":
                gender_male_button.click();
                break;
            case "FEMALE":
                gender_female_button.click();
                break;
        }
    }

    public void verifyListValues(String field, DataTable values) {
        // Convert DataTable to a list of lists of Strings
        List<List<String>> data = values.asLists(String.class);

        // Iterate over each list of values
        for (List<String> value : data) {
            // Iterate over each value in the list
            for (String option : value) {
                By value_option;

                if (field.toUpperCase().contains("QUALIFICATION")) {
                    // Click on the highest qualification dropdown
                    highest_qualification_dropdown.click();
                    // Construct XPath for the option within the qualification dropdown
                    value_option = By.xpath(String.format("//label[contains(., 'qualification')]/following-sibling::div/select[contains(@class, 'SelectInput_select__')]//option[text()='%s']", option));
                    getElement(value_option).click();
                } else {
                    // Construct XPath for the option within the tobacco section
                    value_option = By.xpath(String.format("//p[contains(., 'tobacco')]/ancestor::legend/following-sibling::div//label[text()='%s']", option));
                }
                Assert.assertTrue(getElement(value_option).isDisplayed());
            }
        }
    }


    public void selectQualification(String qualification) {
        if (qualification == null || qualification.isEmpty()) {
            System.out.println("No qualification to select");
        } else {
            highest_qualification_dropdown.click();
            By qualification_option = By.xpath(String.format("//option[text()='%s']", qualification));

            getElement(qualification_option).click();
        }
    }

    public void selectOccupation(String occupation) {
        if (occupation == null || occupation.isEmpty()) {
            System.out.println("No occupation to select");
        } else {
            scrollElementIntoViewAndClick(driver, occupation_dropdown);
            occupation_dropdown.sendKeys(occupation);

            scrollElementIntoViewAndClick(driver, occupation_index_0);
        }
    }

    public void inputMonthlySalary(String amount) {
        scrollElementIntoViewAndClick(driver, monthly_salary_input);
        monthly_salary_input.sendKeys(amount);
    }


    public void clickTobaccoUsageOption(String tobaccoUsageOption) {
        switch (tobaccoUsageOption.toUpperCase()) {
            case "NOT ONCE":
                scrollElementIntoViewAndClick(driver, tobacco_usage_not_once_button);
                break;
            case "ON A DAILY BASIS":
                scrollElementIntoViewAndClick(driver, tobacco_usage_on_a_daily_basis_button);
                break;
            case "ON A WEEKLY BASIS":
                scrollElementIntoViewAndClick(driver, tobacco_usage_on_a_weekly_basis_button);
                break;
            case "A FEW TIMES HERE AND THERE":
                scrollElementIntoViewAndClick(driver, tobacco_usage_few_times_a_here_and_there_button);
                break;
        }
    }

    public void verifyAdvisorCodeFieldDisplayedNotDisplayed(String displayedNotDisplayed) {
        try {
            if (displayedNotDisplayed.toUpperCase().contains("NOT")) {
                isElementNotDisplayed(driver, advisor_code_input);
            } else {
                Assert.assertTrue(advisor_code_input.isDisplayed(), "Advisor code input should be displayed, but it is not.");
            }
        } catch (AssertionError e) {
            Assert.fail(e.getMessage());
        }
    }

    public void clickIamAssistedByAnAdvisorButton() {
        scrollElementIntoViewAndClick(driver, advisor_assisted_checkbox);
    }

}
