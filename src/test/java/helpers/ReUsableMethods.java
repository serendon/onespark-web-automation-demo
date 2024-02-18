package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReUsableMethods {

    private final WebDriver driver;

    public ReUsableMethods() {
        driver = HelperClass.getDriver();
    }

    public WebElement getElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

//    JavaScript to bypass any overlaying elements on click event
    public static void scrollElementIntoViewAndClick(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebDriver driver, By by) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForPathLoad(WebDriver driver, String path) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(path));
    }

    public boolean isElementNotDisplayed(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        try {
            // Check if the element becomes invisible within the specified timeout
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true; // Element is not displayed
        } catch (TimeoutException e) {
            return false; // Element is still displayed
        }
    }
}
