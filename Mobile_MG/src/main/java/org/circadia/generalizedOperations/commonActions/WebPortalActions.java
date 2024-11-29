package org.circadia.generalizedOperations.commonActions;

import org.circadia.generalizedOperations.constants.FrameworkTimeConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.circadia.drivers.WebDriverManager.getWebDriver;

public class WebPortalActions extends AndroidActions {
    public static void clearWebElement(WebElement webElement) {
        waitForWebElementToAppear(webElement);
        webElement.clear();
    }
    public static void enterTextToWebElement(String strategy, String identifier, String txt) {
        setImplicitWaitForWebElement(FrameworkTimeConstants.EXPLICIT_WAIT);
        WebElement webElement = getWebElementBy(strategy, identifier);
        waitForWebElementToAppear(webElement);
        clearWebElement(webElement);
        webElement.sendKeys(txt);
    }
    public static void sendKeyFromKeyboard(Keys key) {
        Actions actions = new Actions(getWebDriver());
        actions.sendKeys(key).perform();
    }
    public static void clickOnWebElement(String strategy, String identifier) {
        WebElement webElement = getWebElementBy(strategy, identifier);
        waitForWebElementToAppear(webElement);
        webElement.click();
    }
    public static String getElementTextOfWebElement(String strategy, String identifier) {
        WebElement webElement = getWebElementBy(strategy, identifier);
        waitForWebElementToAppear(webElement);
        return webElement.getText();
    }
    public static void waitForWebElementToAppear(WebElement element) {
        setImplicitWaitForWebElement(FrameworkTimeConstants.EXPLICIT_WAIT);
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(FrameworkTimeConstants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement getWebElementBy(String strategy, String identifier) {
        return switch (strategy.toLowerCase()) {
            case "id" -> getWebDriver().findElement(By.id(identifier));
            case "xpath" -> getWebDriver().findElement(By.xpath(identifier));
            case "classname" -> getWebDriver().findElement(By.className(identifier));
            case "name" -> getWebDriver().findElement(By.name(identifier));
            case "tagname" -> getWebDriver().findElement(By.tagName(identifier));
            case "linktext" -> getWebDriver().findElement(By.linkText(identifier));
            case "css" -> getWebDriver().findElement(By.cssSelector(identifier));
            default ->
                throw new IllegalArgumentException("Invalid strategy: " + strategy);
        };
    }
    public static boolean isWebElementDisplayed(String strategy, String identifier) {
        try {
            WebElement element = getWebElementBy(strategy, identifier);
            waitForWebElementToAppear(element);
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
    public static void setImplicitWaitForWebElement(int seconds) {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}