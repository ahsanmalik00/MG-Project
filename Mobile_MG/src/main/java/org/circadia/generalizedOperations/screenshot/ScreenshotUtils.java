package org.circadia.generalizedOperations.screenshot;

import org.circadia.generalizedOperations.constants.FrameworkStringConstants;
import org.circadia.drivers.AndroidDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenshotUtils {

  // This class is to handle the change in third party library

  public static String captureScreenshotAsFile(String testName) throws IOException {
    File source = ((TakesScreenshot) AndroidDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    File destination = new File(FrameworkStringConstants.SCREENSHOT_PATH + File.separator + testName + ".png");
    FileUtils.copyFile(source, destination);
    return testName;
  }

  public static String captureScreenshotAsBase64() {
    return ((TakesScreenshot) AndroidDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
  }
}