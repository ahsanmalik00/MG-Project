package org.MG.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.MG.drivers.WebDriverManager.getWebDriver;

public class Utility {

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForInSeconds(int seconds) throws InterruptedException {
        Thread.sleep(Duration.ofMinutes(seconds));
    }
}
