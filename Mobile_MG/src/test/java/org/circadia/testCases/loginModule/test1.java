package org.circadia.testCases.loginModule;
import org.circadia.generalizedOperations.customannotations.FrameworkAnnotation;
import org.circadia.generalizedOperations.enums.CategoryType;
import org.circadia.pageObjects.MGMobileAppPages.loginModule.LoginPagePOM;
import org.circadia.testHelpers.base.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.circadia.drivers.AndroidDriverManager.getDriver;
import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.AUTHOR_UMAIR_KHAN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class test1 extends AndroidBaseTest {
    LoginPagePOM loginPagePOM;
    private WebDriver driver;
    @BeforeClass
    public void preSetup() {
        driver = getDriver();
        loginPagePOM = new LoginPagePOM();
    }

    @FrameworkAnnotation(author = AUTHOR_UMAIR_KHAN, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test(priority = 1, description = "Valid username and Pass")
    public void LO_TC_466095() throws InterruptedException { // Covers LO_TC_466094 also
        WebElement usernameField = driver.findElement(By.id("com.circadia.circadiarespiratorytracker.debug:id/emailText")); // Replace with actual ID
        usernameField.click();
        usernameField.sendKeys("Ahsan@00gmail.com");
        usernameField.sendKeys(Keys.ENTER);

        WebElement loginBtn= driver.findElement(By.id("com.circadia.circadiarespiratorytracker.debug:id/BTlogin"));
        loginBtn.click();

        Thread.sleep(4000);

    }

    @AfterMethod
    public void postSetupMethod(){
        resetApp();
    }
    @AfterClass
    public void postSetup() {
        loginPagePOM = null;
    }
}