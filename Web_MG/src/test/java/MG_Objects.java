//
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.MG.PageObjects.MGProject;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//
//import static org.MG.PageObjects.MGsignPageLocators.firstNameLocator;
//import static org.MG.Utilities.Utility.scrollToElement;
//import static org.MG.drivers.WebDriverManager.*;
//
//
//public class MG_Objects {
//    WebDriver driver;
//    MGProject MGProject;
//
//    @BeforeSuite
//    public void setUp() {
//        // Setup ChromeDriver using WebDriverManager
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @BeforeTest
//    public void setUpTest() {
////        driver.get("https://demoqa.com/automation-practice-form/");
//        MGProject.navigateToDemoQAPage();
//    }
//
//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//
////    @BeforeSuite
////    public void setUp() {
////        setUpWebDriver();
////        maximizeWindow();
////        MGProject = new MGProject();
////    }
//
//
////    @Parameters("browser")
////    @BeforeTest
////
////    public void setUp(String browser) {
////        MGProject.navigateToDemoQAPage();
////        if (browser.equalsIgnoreCase("chrome")) {
////            WebDriverManager.chromedriver().setup();
////            driver = new ChromeDriver();
////        } else if (browser.equalsIgnoreCase("firefox")) {
////            WebDriverManager.firefoxdriver().setup();
////            driver = new FirefoxDriver();
////
////        }
////    }
//
//
//
//
//    @Test
//    public void TC01_Fill_Form_POM() throws InterruptedException {
//        MGProject.fillFirstName();
//        MGProject.fillLastName();
//        MGProject.fillUserEmail();
//        MGProject.fillphone();
//        MGProject.fillgender();
//        MGProject.subjectfill();
////        Thread.sleep(3000);
//        MGProject.fillhobbies();
//        MGProject.uploadpic();
//        MGProject.dob();
//        MGProject.address();
////        Thread.sleep(3000);
//        MGProject.fillstate();
////        Thread.sleep(3000);
//        MGProject.fillcity();
////        Thread.sleep(10000);
//        MGProject.submit();
////        Thread.sleep(20000);
//
//    }
//
//    @AfterSuite
//    public void tearDown() {
//       // MGProject = null;
//
//    }
//}


import org.MG.PageObjects.MGProject;
import org.testng.annotations.*;

import static org.MG.drivers.WebDriverManager.*;

public class MG_Objects {

    MGProject MGProject;

    @BeforeSuite
    public void setUp() {
        setUpWebDriver();
        maximizeWindow();
        MGProject = new MGProject();
    }

    @BeforeTest
    public void setUpTest() {
        MGProject.navigateToDemoQAPage();
    }

    @Test
    public void TC01_Fill_Form_POM() throws InterruptedException {
        MGProject.signin();
        Thread.sleep(3000);
        MGProject.Phone();
        Thread.sleep(2000);

    }

    @AfterTest
    public void TearDown() {
        closeWebDriver();
    }

    @AfterSuite
    public void tearDown() {
        MGProject = null;
        quitWebDriver();
    }
}
