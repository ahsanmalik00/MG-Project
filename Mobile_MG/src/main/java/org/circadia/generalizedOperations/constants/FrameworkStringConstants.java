package org.circadia.generalizedOperations.constants;

import org.circadia.generalizedOperations.enums.ConfigJson;
import org.circadia.generalizedOperations.enums.ConfigProperties;
import org.circadia.generalizedOperations.configloader.PropertyUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.circadia.generalizedOperations.configloader.JsonUtils.getConfig;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.PROJECT_PATH;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkStringConstants {
  public static final String APPIUM_SERVER_HOST = getConfig(ConfigJson.APPIUM_URL);
  public static final String APPIUM_JS_PATH = "C:/Users/Ahsan/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
  public static final String NODEJS_PATH = "C:/Program Files/nodejs/node.exe";
  public static final int APPIUM_SERVER_PORT = 4723;
  public static final int AVD_LAUNCH_TIMEOUT = 300;
  public static final int AVD_READY_TIMEOUT = 300;
  public static final String LOG_LEVEL_NAME = "info";
  public static final String DEVICE_IOS = "ios";
  public static final String URL_POSTFIX = "/wd/hub";
  public static final String DRIVER_UIAUTOMATOR = "uiautomator2";
  public static final String DRIVER_XCTEST = "xcuitest";
  public static final String DRIVER_CHROME_AUTO_DOWNLOAD = "chromedriver_autodownload";
  public static final String ID = "id";
  public static final String XPATH = "xpath";
  public static final String CSS_SELECTOR = "css";
  public static final String AUTHOR_UMAIR_KHAN = "Umair Khan";
  public static final String AUTHOR_YASIR_AMIN = "Yasir Amin";
  public static final String AUTHOR_UMAIR_IRSHAD = "Umair Irshad";
  public static final String SCREENSHOT_PATH = PROJECT_PATH + File.separator + "screenshots";
  private static final String EXTENT_REPORT_PATH = PROJECT_PATH + File.separator + "extent-test-report";
  private static final String APPIUM_SERVER_LOGS_PATH = PROJECT_PATH + File.separator + "server-logs";
  private static final String SCREEN_RECORDING_PATH = PROJECT_PATH + File.separator + "screen-recordings";
  public static String getCurrentDateTime(String pattern) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    LocalDateTime localDateTime = LocalDateTime.now();
    return dateTimeFormatter.format(localDateTime);
  }
  public static String getExtentReportPath() {
    if (PropertyUtils.getPropertyValue(ConfigProperties.OVERRIDE_REPORTS).equalsIgnoreCase("yes")) {
      return EXTENT_REPORT_PATH + File.separator + "E2E.html";
    } else {
      return EXTENT_REPORT_PATH + File.separator + getCurrentDateTime("yyyy_MM_dd-HH") + File.separator + "CProTestReport.html";
    }
  }
  public static String getAppiumServerLogsPath() {
    if (PropertyUtils.getPropertyValue(ConfigProperties.OVERRIDE_SERVER_LOG).equalsIgnoreCase("yes")) {
      return APPIUM_SERVER_LOGS_PATH + File.separator + "server.log";
    } else {
      return APPIUM_SERVER_LOGS_PATH + File.separator + getCurrentDateTime("yyyy_MM_dd-HH") + File.separator + "server.log";
    }
  }
  public static void createDirectory(String filePath){
    File screenRecordingDirectory = new File(filePath);
    if(!screenRecordingDirectory.exists()){
      boolean pathClassNameDirCreated = screenRecordingDirectory.mkdirs();
      if (!pathClassNameDirCreated) {
        throw new RuntimeException("Failed to create screen recordings directory");
      }
    }
  }
  public static String getScreenRecordingsPath(String className) {
    String screenRecordingFilePath = SCREEN_RECORDING_PATH + File.separator + getCurrentDateTime("yyyy_MM_dd") + File.separator + className;
    createDirectory(screenRecordingFilePath);
    return screenRecordingFilePath;
  }
  public static String getPlatformName() {
    return getConfig(ConfigJson.PLATFORM_NAME);
  }
  public static String getDeviceName() {
    return getConfig(ConfigJson.DEVICE_NAME);
  }
  public static String getAppPackage() {
    return getConfig(ConfigJson.APP_PACKAGE);
  }
  public static String getAppMainActivity() {
    return getConfig(ConfigJson.APP_ACTIVITY);
  }
  public static String getIdentifiersGeneralPath() {
    return getAppPackage() + ":id" + File.separator;
  }

}