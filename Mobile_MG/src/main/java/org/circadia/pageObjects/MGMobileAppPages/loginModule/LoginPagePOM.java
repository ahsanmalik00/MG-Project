package org.circadia.pageObjects.MGMobileAppPages.loginModule;

import org.circadia.generalizedOperations.commonActions.AndroidActions;

import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.*;
import static org.circadia.generalizedOperations.constants.FrameworkTimeConstants.*;

import static org.circadia.pageObjects.MGMobileAppPages.loginModule.LoginModuleIdentifiers.*;
import static org.circadia.pageObjects.MGMobileAppPages.loginModule.LoginPageTestData.*;

public class LoginPagePOM extends AndroidActions {

    public void LogIn(String email, String password){
        if(isDisplayed(ID,EmailTxtBox,FIVE_SECOND_WAIT)) {
            enterText(ID, EmailTxtBox, email);
            click(ID, LoginBtn);
            enterText(ID, passwordTxtBox, password);
            click(ID, OKBtn);
            setImplicitWait(LOG_IN_WAIT);
        }
        else {
            resetApp();
            LogIn(CORRECT_USER_EMAIL, CORRECT_USER_PASSWORD);
        }
    }
    public void CreatePin(String pin)
    {
        enterText(ID,TxtPinEntry,pin);
        enterText(ID,TxtPinEntry,pin);
    }
    public void EnterEmailAndClickLoginButton(String email)
    {
        enterText(ID, EmailTxtBox, email);
        click(ID, LoginBtn);
    }
    public void tabToUnlockApp(){
        if (isDisplayed(ID,lockScreenAlertLayout, TEN_SECOND_WAIT)) {
            click(ID,lockScreenAlertLayout);
        } else{
            click(ID,tap_to_unlock_btn);
        }
    }
     public boolean isTabToUnlockDisplayed(){
         if (isDisplayed(ID,lockScreenAlertLayout, NINE_SECOND_WAIT)) {
             return true;
         }
         else return isDisplayed(ID, tap_to_unlock_btn, NINE_SECOND_WAIT);
     }
    public void tabOnCircadiaLOGO(int numberOfTabs, int waitBeforeTab) throws InterruptedException {
        for (int i = 0; i < numberOfTabs; i++) {
            click(ID,circadiaLogo);
            setFreezeWait(waitBeforeTab);
        }
    }
    public void enterPinToUnlockApp(){
        enterText(ID,etPinOne,PIN_SINGLE_VALUE);
        enterText(ID,etPinTwo,PIN_SINGLE_VALUE);
        enterText(ID,etPinThree,PIN_SINGLE_VALUE);
        enterText(ID,etPinFour,PIN_SINGLE_VALUE);
    }
    public void enterWrongPin(){
        enterText(ID,etPinOne,PIN_SINGLE_VALUE);
        enterText(ID,etPinTwo,PIN_WRONG_SINGLE_VALUE);
        enterText(ID,etPinThree,PIN_SINGLE_VALUE);
        enterText(ID,etPinFour,PIN_SINGLE_VALUE);
    }
}