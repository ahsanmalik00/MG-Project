package org.MG.PageObjects;

import org.MG.Enums.MGenum;
import org.MG.constants.FrameworkPathConstants;

import static org.MG.ConfigLoaders.JsonUtils.getValue;

public class MGsignPageLocators {
    public static final String signinlocator = getValue(MGenum.SIGN_IN, FrameworkPathConstants.LOCATORS_FILE_PATH);
    public static final String phone1locator = getValue(MGenum.PHONE_1, FrameworkPathConstants.LOCATORS_FILE_PATH);

}
