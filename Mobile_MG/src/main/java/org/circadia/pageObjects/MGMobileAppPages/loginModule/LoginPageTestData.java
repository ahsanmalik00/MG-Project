package org.circadia.pageObjects.MGMobileAppPages.loginModule;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static org.circadia.generalizedOperations.commonActions.AppiumUtilities.loadDotenv;
import static org.circadia.generalizedOperations.configloader.JsonUtils.getValue;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.ENV_FILE_DIR;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.LOGIN_MODULE_TEST_DATA;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LoginPageTestData {
  static Dotenv dotenv = loadDotenv(ENV_FILE_DIR);
  public static final String CORRECT_USER_EMAIL_FOR_REPORTS = dotenv.get("emailForReports");
  public static final String CORRECT_USER_PASSWORD_REPORTS = dotenv.get("passwordForReports");

  public static final String CORRECT_USER_EMAIL = dotenv.get("email");
  public static final String CORRECT_USER_EMAIL_2 = dotenv.get("email2");

  public static final String CORRECT_USER_PASSWORD = dotenv.get("password");
  public static final String INCORRECT_USER_EMAIL = getValue("INCORRECT_USER_EMAIL", LOGIN_MODULE_TEST_DATA);
  public static final String INCORRECT_USER_PASSWORD = getValue("INCORRECT_USER_PASSWORD", LOGIN_MODULE_TEST_DATA);
  public static final String INCORRECT_USER_PASSWORD_2 = getValue("INCORRECT_USER_PASSWORD_2", LOGIN_MODULE_TEST_DATA);
  public static final String USERNAME_ATTRIBUTE = getValue("USERNAME_ATTRIBUTE", LOGIN_MODULE_TEST_DATA);
  public static final String PASSWORD_ATTRIBUTE = getValue("PASSWORD_ATTRIBUTE", LOGIN_MODULE_TEST_DATA);

  public static final String PIN = getValue("PIN", LOGIN_MODULE_TEST_DATA);
  public static final String WRONG_PIN = getValue("WRONG_PIN", LOGIN_MODULE_TEST_DATA);
  public static final String WRONG_PIN_2 = getValue("WRONG_PIN_2", LOGIN_MODULE_TEST_DATA);
  public static final String PIN_SINGLE_VALUE = getValue("PIN_SINGLE_VALUE", LOGIN_MODULE_TEST_DATA);
  public static final String PIN_WRONG_SINGLE_VALUE = getValue("PIN_WRONG_SINGLE_VALUE", LOGIN_MODULE_TEST_DATA);
  public static final String INVALID_LOGIN_ERROR_MESSAGE = getValue("INVALID_LOGIN_ERROR_MESSAGE", LOGIN_MODULE_TEST_DATA);
  public static final String VALID_LOGIN_SUCCESS_MESSAGE = getValue("VALID_LOGIN_ERROR_MESSAGE", LOGIN_MODULE_TEST_DATA);
  public static final String CHECKED = getValue("CHECKED", LOGIN_MODULE_TEST_DATA);
  public static final String TRUE = getValue("TRUE", LOGIN_MODULE_TEST_DATA);
  public static final int NINE_HUNDRED_MILLI_SECOND_WAIT = Integer.parseInt(getValue("NINE_HUNDRED_MILLI_SECOND_WAIT", LOGIN_MODULE_TEST_DATA));
  public static final int TEN_MILLI_SECOND = Integer.parseInt(getValue("TEN_MILLI_SECOND", LOGIN_MODULE_TEST_DATA));
  public static final int FIVE_TIMES_TAB = Integer.parseInt(getValue("FIVE_TIMES_TAB", LOGIN_MODULE_TEST_DATA));
  public static final int FOUR_TIMES_TAB = Integer.parseInt(getValue("FOUR_TIMES_TAB", LOGIN_MODULE_TEST_DATA));
  public static final String EMPTY_USERNAME_ERROR_MSG = getValue("EMPTY_USERNAME_ERROR_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String ENTER_YOUR_PASSWORD_MSG = getValue("ENTER_YOUR_PASSWORD_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String SIGNING_IN_AS_MSG = getValue("SIGNING_IN_AS_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String FORGOT_PASSWORD_TXT = getValue("FORGOT_PASSWORD_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String SIGN_IN_TXT = getValue("SIGN_IN_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String NOT_YOU_TXT = getValue("NOT_YOU_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String RESET_PASSWORD_TXT = getValue("RESET_PASSWORD_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String EMAIL_DOES_NOT_EXIST_MSG = getValue("EMAIL_DOES_NOT_EXIST_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String CANCEL_TXT = getValue("CANCEL_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String SAVE_TXT = getValue("SAVE_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String PIN_DOES_NOT_MATCH_MSG = getValue("PIN_DOES_NOT_MATCH_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String CONNECTION_ISSUE_TXT_MSG = getValue("CONNECTION_ISSUE_TXT_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String TRY_AGAIN_BTN_TXT = getValue("TRY_AGAIN_BTN_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String INCORRECT_PIN_TITLE = getValue("INCORRECT_PIN_TITLE", LOGIN_MODULE_TEST_DATA);
  public static final String INCORRECT_PIN_DESCRIPTION = getValue("INCORRECT_PIN_DESCRIPTION", LOGIN_MODULE_TEST_DATA);
  public static final String FORGOT_PIN_TITLE = getValue("FORGOT_PIN_TITLE", LOGIN_MODULE_TEST_DATA);
  public static final String SUPPORT_DETAILS = getValue("SUPPORT_DETAILS", LOGIN_MODULE_TEST_DATA);
  public static final String OK_TXT = getValue("OK_TXT", LOGIN_MODULE_TEST_DATA);
  public static final String ENTER_A_VALID_CODE_TEXT_MSG = getValue("ENTER_A_VALID_CODE_TEXT_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String CODE_IS_REQUIRED_TEXT_MSG = getValue("CODE_IS_REQUIRED_TEXT_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String PASSWORD_IS_REQUIRED_TEXT_MSG = getValue("PASSWORD_IS_REQUIRED_TEXT_MSG", LOGIN_MODULE_TEST_DATA);
  public static final String CONFIRM_PASSWORD_IS_REQUIRED_TEXT_MSG = getValue("CONFIRM_PASSWORD_IS_REQUIRED_TEXT_MSG", LOGIN_MODULE_TEST_DATA);
}