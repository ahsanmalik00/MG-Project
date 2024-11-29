package org.MG.PageObjects;

import org.MG.Enums.MGenum;
import org.MG.constants.FrameworkPathConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.MG.ConfigLoaders.JsonUtils.getValue;
import static org.MG.PageObjects.MGsignPageLocators.*;
import static org.MG.Utilities.Utility.scrollToElement;
import static org.MG.drivers.WebDriverManager.getWebDriver;

public class MGProject {

    public void navigateToDemoQAPage() {
        getWebDriver().get(getValue(MGenum.URL, FrameworkPathConstants.TEST_DATA_FILE_PATH));
    }

    public void signin(){
     WebElement SignIn= getWebDriver().findElement(By.xpath(signinlocator));
     scrollToElement(SignIn);
     SignIn.click();
    }

    public void Phone() {
        WebElement Phone1= getWebDriver().findElement(By.cssSelector(phone1locator));
        scrollToElement(Phone1);
        Phone1.sendKeys(phone1locator);
    }
}
