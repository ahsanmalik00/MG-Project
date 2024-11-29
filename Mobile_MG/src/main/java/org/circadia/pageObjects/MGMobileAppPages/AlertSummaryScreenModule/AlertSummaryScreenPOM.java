package org.circadia.pageObjects.MGMobileAppPages.AlertSummaryScreenModule;

import org.circadia.generalizedOperations.commonActions.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.ID;
import static org.circadia.pageObjects.MGMobileAppPages.loginModule.LoginModuleIdentifiers.lockScreenAlertLayout;

public class AlertSummaryScreenPOM extends AndroidActions {


    public List<WebElement> getListOfAlertsElements() {
         return getListOfElementsBy(ID, lockScreenAlertLayout);
    }

    public WebElement getAlertCardElementIfContains(List<WebElement> elements, String s) {
        for (WebElement ele : elements) {
            if(ele.findElement(By.id("textView")).getText().contains(s)){
                return ele;
            }
        }
        return null;
    }

    public void clickIfContains(List<WebElement> elements, String s) {
        for (WebElement ele : elements) {
            if(ele.findElement(By.id("textView")).getText().contains(s)){
                ele.click();
                break;
            }
        }
    }
}
