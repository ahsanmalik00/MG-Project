package org.circadia.drivers;
import org.circadia.generalizedOperations.enums.ConfigJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.circadia.generalizedOperations.configloader.JsonUtils.getConfig;
import static org.circadia.generalizedOperations.constants.WebPortalStringConstantsAndTestData.*;


public class WebDriverManager {
    private static WebDriver driver;
    public static void setUpWebDriver() {
        System.setProperty(CHROME_WEB_DRIVER, CHROME_DRIVER_EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        driver = new ChromeDriver(options);
    }
    public static void quitWebDriver() {
        driver.quit();
        driver = null;
    }
    public static void closeWebDriver() {
        driver.close();
    }
    public static WebDriver getWebDriver() {
        return driver;
    }
    public static void navigateTo(String url) {
        driver.get(url);
    }
    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }
    public static String getWebPortalURL() {
        return getConfig(ConfigJson.WEB_PORTAL_URL);
    }
}