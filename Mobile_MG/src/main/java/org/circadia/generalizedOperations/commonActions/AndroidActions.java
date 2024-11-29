package org.circadia.generalizedOperations.commonActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.circadia.generalizedOperations.constants.FrameworkTimeConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static org.circadia.drivers.AndroidDriverManager.getDriver;
import static org.circadia.generalizedOperations.constants.FrameworkTimeConstants.THREE_THOUSAND_MILLI_SECOND_WAIT;
import static org.circadia.pageObjects.MGMobileAppPages.flashingClinicalAlertsModule.FlashingClinicalAlertsTestData.NEXT_TEST_WAIT;
import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.*;
import static org.circadia.pageObjects.MGMobileAppPages.loginModule.LoginPageTestData.TRUE;
import static org.circadia.pageObjects.MGMobileAppPages.loginModule.LoginModuleIdentifiers.ToastMsg;

public class AndroidActions extends AppiumUtilities {
    private static Wait < WebDriver > wait = null;

    public boolean isDisplayed(String Strategy, String Value) {
        try {
            WebElement element = getElementBy(Strategy, Value);
            waitForElementToAppear(element);
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
    public boolean isDisplayed(String Strategy, String Value, int timeOutTime) {
        try {
            setImplicitWait(timeOutTime);
            WebElement element = getElementBy(Strategy, Value);
            waitForElementToAppear(element, timeOutTime);
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
    public boolean isDisplayed(String Strategy, String Value, int timeOutTime, String elementName) {
        try {
            WebElement element = getElementBy(Strategy, Value);
            waitForElementToAppear(element, timeOutTime, elementName);
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            // // ExtentReportLogger.logInfo("Element <b>" + elementName + "</b> is not displayed");
            return false;
        }
    }

    public void clear(WebElement mobileElement) {
        waitForElementToAppear(mobileElement);
        mobileElement.clear();
    }


    public void clear(WebElement mobileElement, int timeOutTime) {
        try {
            waitForElementToAppear(mobileElement, timeOutTime);
            mobileElement.clear();
        } catch (Exception e) {
            assert false;
        }
    }

    public void enterText(String strategy, String identifier, String txt) {
        WebElement mobileElement = getElementBy(strategy, identifier);
        waitForElementToAppear(mobileElement);
        mobileElement.sendKeys(txt);
    }
    public void enterText(String strategy, String identifier, String txt, String elementName) {
        try {
            WebElement mobileElement = getElementBy(strategy, identifier);
            waitForElementToAppear(mobileElement, FrameworkTimeConstants.EXPLICIT_WAIT, elementName);
            mobileElement.sendKeys(txt);
            // ExtentReportLogger.logInfo("Entered text '" + txt + "' in element <b>" + elementName + "</b>");
        } catch (Exception e) {
            // ExtentReportLogger.warning("Failed to enter text in element <b>" + elementName + "</b>");
            assert false;
        }
    }
    public void enterText(String strategy, String identifier, String txt, String elementName, int timeOutTime) {
        try {
            WebElement mobileElement = getElementBy(strategy, identifier);
            waitForElementToAppear(mobileElement, timeOutTime, elementName);
            mobileElement.sendKeys(txt);
            // ExtentReportLogger.logInfo("Entered text '" + txt + "' in element <b>" + elementName + "</b>");
        } catch (Exception e) {
            // ExtentReportLogger.warning("Failed to enter text in element <b>" + elementName + "</b>");
            assert false;
        }
    }

    public void click(String strategy, String identifier) {
        WebElement mobileElement = getElementBy(strategy, identifier);
        waitForElementToAppear(mobileElement);
        mobileElement.click();
    }
    public void click(String strategy, String identifier, String elementName) {
        try {
            WebElement mobileElement = getElementBy(strategy, identifier);
            waitForElementToAppear(mobileElement, FrameworkTimeConstants.EXPLICIT_WAIT, elementName);
            mobileElement.click();
            // ExtentReportLogger.logInfo("Clicked on element <b>" + elementName + "</b>");
        } catch (Exception e) {
            // ExtentReportLogger.warning("Failed to click on element <b>" + elementName + "</b>");
            assert false;
        }
    }

    public void click(String strategy, String identifier, String elementName, int timeOutTime) {
        try {
            WebElement mobileElement = getElementBy(strategy, identifier);
            waitForElementToAppear(mobileElement, timeOutTime, elementName);
            mobileElement.click();
            // ExtentReportLogger.logInfo("Clicked on element <b>" + elementName + "</b>");
        } catch (Exception e) {
            // ExtentReportLogger.warning("Failed to click on element <b>" + elementName + "</b>");
            assert false;
        }
    }

    public String getElementText(String strategy, String identifier) {
        WebElement mobileElement = getElementBy(strategy, identifier);
        waitForElementToAppear(mobileElement);
        return mobileElement.getText();
    }
    public String getElementText(String strategy, String identifier, String elementName) {
        try {
            WebElement mobileElement = getElementBy(strategy, identifier);
            waitForElementToAppear(mobileElement, FrameworkTimeConstants.EXPLICIT_WAIT, elementName);
            // ExtentReportLogger.logInfo("Retrieved text from element <b>" + elementName + "</b>: " + elementText);
            return mobileElement.getText();
        } catch (Exception e) {
            // ExtentReportLogger.warning("Failed to retrieve text from element <b>" + elementName + "</b>");
            return null;
        }
    }
    public String getElementText(String strategy, String identifier, String elementName, int timeOutTime) {
        try {
            WebElement mobileElement = getElementBy(strategy, identifier);
            waitForElementToAppear(mobileElement, timeOutTime, elementName);
            // ExtentReportLogger.logInfo("Retrieved text from element <b>" + elementName + "</b>: " + elementText);
            return mobileElement.getText();
        } catch (Exception e) {
            // ExtentReportLogger.warning("Failed to retrieve text from element <b>" + elementName + "</b>");
            return null;
        }
    }
    public void waitForElementToAppear(WebElement ele) {
        setImplicitWait(FrameworkTimeConstants.EXPLICIT_WAIT);
        wait = new FluentWait < WebDriver > (getDriver())
                .withTimeout(Duration.ofSeconds(FrameworkTimeConstants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public void waitForElementToAppear(WebElement ele, int timeOutTime) {
        setImplicitWait(timeOutTime);
        wait = new FluentWait < WebDriver > (getDriver())
                .withTimeout(Duration.ofSeconds(FrameworkTimeConstants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public void waitForElementToAppear(WebElement ele, int timeOutTime, String elementName) {
        try {
            setImplicitWait(timeOutTime);
            // ExtentReportLogger.logInfo("Waiting for element <b>" + elementName + "</b> to appear");
            wait = new FluentWait < WebDriver > (getDriver())
                    .withTimeout(Duration.ofSeconds(timeOutTime));
            wait.until(ExpectedConditions.visibilityOf(ele));
        } catch (TimeoutException e) {
            // ExtentReportLogger.warning("Timeout occurred while waiting for element <b>" + elementName + "</b> to appear");
            assert false;
        }
    }

    public void scrollMobileScreen(String direction) {
        Dimension screenSize = getDriver().manage().window().getSize();
        int startX = screenSize.getWidth() / 2;
        int startY, endY;

        if (direction.equalsIgnoreCase("down")) {
            startY = (int)(screenSize.getHeight() * 0.8);
            endY = (int)(screenSize.getHeight() * 0.2);
        } else if (direction.equalsIgnoreCase("up")) {
            startY = (int)(screenSize.getHeight() * 0.2);
            endY = (int)(screenSize.getHeight() * 0.8);
        } else {
            throw new IllegalArgumentException("Invalid direction. Please specify 'up' or 'down'.");
        }

        new TouchAction < > (getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }
    public void scrollToUp(String strategy, String id) {
        WebElement element = getElementBy(strategy, id);
        Dimension dimensions = getDriver().manage().window().getSize();
        int scrollStart = (int)(dimensions.getHeight() * 0.5);
        int scrollEnd = (int)(dimensions.getHeight() * 0.45);
        int elementX = element.getLocation().getX();
        int elementY = element.getLocation().getY();
        TouchAction < ? > touchAction = new TouchAction < > (getDriver());
        touchAction.press(PointOption.point(elementX, elementY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(scrollStart, scrollEnd))
                .release()
                .perform();
    }
    public String getToastMessage() {
        WebElement toastElement = getElementBy(XPATH, ToastMsg);
        return toastElement.getText();
    }
    public boolean isElementChecked(String strategy, String identifier, String attribute) {
        WebElement mobileElement = getElementBy(strategy, identifier);
        String checkedValue = getElementAttribute(mobileElement, attribute);
        boolean isChecked = checkedValue != null && checkedValue.equalsIgnoreCase(TRUE);
        String isCheckedLogMsg = "Element with strategy: " + strategy + ", identifier: " + identifier;
        if (isChecked) {
            // ExtentReportLogger.logInfo( isCheckedLogMsg + " is checked");
        } else {
            // ExtentReportLogger.logInfo( isCheckedLogMsg + " is not checked");
        }
        return isChecked;
    }
    protected static String getElementAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }
    public void closeApp() {
        getDriver().terminateApp(getAppPackage());
    }
    public void launchApp() throws InterruptedException {
        getDriver().startActivity(new Activity(getAppPackage(), getAppMainActivity()));
        setFreezeWait(NEXT_TEST_WAIT);
    }
    public void lockDevice() {
        getDriver().lockDevice();
    }
    public void unlockDevice() {
        getDriver().unlockDevice();
    }
    public void resetApp() {
        try {
            unlockDevice();
            setFreezeWait(THREE_THOUSAND_MILLI_SECOND_WAIT);
            getDriver().resetApp();
            setFreezeWait(THREE_THOUSAND_MILLI_SECOND_WAIT);
            unlockDevice();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public List < String > getElementTextList(String strategy, String identifier) {
        List < String > textList = new ArrayList < > ();
        List < WebElement > elements = getListOfElementsBy(strategy, identifier);
        try {
            for (WebElement element: elements) {
                textList.add(element.getText());
                System.out.println(element.getText());
            }
        } catch (Exception e) {
            // ExtentReportLogger.warning("List is empty");
        }
        return textList;
    }
    public boolean checkListIsSorted(List < String > listToCheck) {
        if (!listToCheck.isEmpty()) {
            for (int i = 1; i < listToCheck.size(); i++) {
                String current = listToCheck.get(i);
                String previous = listToCheck.get(i - 1);

                if (compareStrings(current, previous) < 0) {
                    // ExtentReportLogger.warning("List is not sorted");
                    return false; // The list is not sorted
                }
            }
        }
        // ExtentReportLogger.logInfo("List is sorted");
        return true; // The list is sorted
    }
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        List<String> tempList = new ArrayList<>(list2);
        for (String element : list1) {
            if (!tempList.contains(element)) {
                return false;
            }
            tempList.remove(element);
        }
        return tempList.isEmpty();
    }
    public static boolean isItemAvailableInList(List<String> list1, String item) {
        return list1.contains(item);
    }
    private static int compareStrings(String str1, String str2) {
        int num1 = Integer.parseInt(str1.replaceAll("[^0-9]", ""));
        int num2 = Integer.parseInt(str2.replaceAll("[^0-9]", ""));
        if (num1 != num2) {
            return Integer.compare(num1, num2);
        }
        String suffix1 = str1.replaceAll("[^A-Za-z]", "");
        String suffix2 = str2.replaceAll("[^A-Za-z]", "");
        return suffix1.compareTo(suffix2);
    }
}