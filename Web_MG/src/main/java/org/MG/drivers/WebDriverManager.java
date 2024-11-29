package org.MG.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverManager {

    private static WebDriver driver;

    public static void setUpWebDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
}