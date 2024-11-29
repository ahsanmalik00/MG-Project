package org.circadia.generalizedOperations.constants;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;

import static org.circadia.generalizedOperations.commonActions.AppiumUtilities.loadDotenv;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.ENV_FILE_DIR;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.PROJECT_PATH;

public class WebPortalStringConstantsAndTestData {
    // WEB FRAMEWORK STRING CONSTANTS
    public static final String TEST_RESOURCES_DIR = PROJECT_PATH + File.separator + "src/test/resources";
    public static final String CHROME_DRIVER_EXE_PATH =
            TEST_RESOURCES_DIR + File.separator + "executables" + File.separator + "chromedriver";
    public static final String CHROME_WEB_DRIVER = "webdriver.chrome.driver";

    // WEB LOGIN STRING CONSTANTS
    static Dotenv dotenv = loadDotenv(ENV_FILE_DIR);
    public static final String USER_EMAIL_WEB_PORTAL = dotenv.get("email");
    public static final String PASSWORD_WEB_PORTAL = dotenv.get("password");
    public static final int IMPLICIT_WEB_WAIT = 50;

    // WEB CLINICAL ALERTS STRING CONSTANTS
    public static final String HEART_RATE_VALUE = "45";
    public static final String BP_VALUE = "22/45";
    public static final String SP02_VALUE = "12";
    public static final String TEMP = "30";
}