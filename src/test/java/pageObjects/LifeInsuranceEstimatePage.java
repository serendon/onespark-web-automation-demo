package pageObjects;

import helpers.HelperClass;
import helpers.ReUsableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LifeInsuranceEstimatePage extends ReUsableMethods {
    private final WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'Life Cover')]/following-sibling::span[contains(@class, 'Input_display')]")
    WebElement life_cover_monthly_amount;

    @FindBy(xpath = "//span[contains(text(), 'Disability Cover')]/following-sibling::span[contains(@class, 'Input_display')]")
    WebElement disability_cover_monthly_amount;

    @FindBy(xpath = "//span[contains(text(), 'Temporary Income Protection')]/following-sibling::span[contains(@class, 'Input_display')]")
    WebElement temp_income_protection_cover_monthly_amount;

    @FindBy(xpath = "//span[contains(text(), 'Illness Cover')]/following-sibling::span[contains(@class, 'Input_display')]")
    WebElement illness_cover_monthly_amount;

    public LifeInsuranceEstimatePage() {
        driver = HelperClass.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void verifyUrlPath(String path) {
        Assert.assertTrue(driver.getCurrentUrl().contains(path), "User is not navigated to the correct url path");
    }

    public void verifyCoverAmount(String cover, String amount) {
        boolean isNotDisplayed = amount.toUpperCase().contains("NOT");
        WebElement coverElement = null;

        switch (cover.toUpperCase()) {
            case "LIFE COVER":
                coverElement = life_cover_monthly_amount;
                break;
            case "DISABILITY COVER":
                coverElement = disability_cover_monthly_amount;
                break;
            case "TEMPORARY INCOME PROTECTION":
                coverElement = temp_income_protection_cover_monthly_amount;
                break;
            case "ILLNESS COVER":
                coverElement = illness_cover_monthly_amount;
                break;
        }

        if (isNotDisplayed) {
            isElementNotDisplayed(driver, coverElement);
        } else {
            Assert.assertEquals(amount, coverElement.getText());
        }
    }
}

