package org.circadia.generalizedOperations.reports;

import org.circadia.generalizedOperations.constants.FrameworkStringConstants;
import org.circadia.generalizedOperations.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentReportManager {

  private static final ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkStringConstants.getExtentReportPath());
  private static final ThreadLocal < ExtentTest > threadLocalExtentTest = new ThreadLocal < > ();
  private static ExtentReports extentReports;

  public static void initExtentReport() {
    try {
      if (Objects.isNull(extentReports)) {
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        InetAddress ip = InetAddress.getLocalHost();
        String hostname = ip.getHostName();
        extentReports.setSystemInfo("Host Name", hostname);
        extentReports.setSystemInfo("Environment", "Mobile Automation - Appium");
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extentSparkReporter.config().setDocumentTitle("HTML Report");
        extentSparkReporter.config().setReportName("Mobile Automation Test");
        extentSparkReporter.config().setTheme(Theme.DARK);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void createTest(String testCaseName) {
    setExtentTest(extentReports.createTest(testCaseName));
  }

  public static void flushExtentReport() {
    if (Objects.nonNull(extentReports)) {
      extentReports.flush();
    }
    unload();
    try {
      Desktop.getDesktop().browse(new File(FrameworkStringConstants.getExtentReportPath()).toURI());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static ExtentTest getExtentTest() {
    return threadLocalExtentTest.get();
  }

  static void setExtentTest(ExtentTest test) {
    threadLocalExtentTest.set(test);
  }

  static void unload() {
    threadLocalExtentTest.remove();
  }

  public static void addAuthors(String[] authors) {
    for (String author: authors) {
      getExtentTest().assignAuthor(author);
    }
  }

  public static void addCategories(CategoryType[] categories) {
    for (CategoryType category: categories) {
      getExtentTest().assignCategory(category.toString());
    }
  }

  public static void addDevices() {
    getExtentTest().assignDevice(FrameworkStringConstants.getPlatformName() + "-" + FrameworkStringConstants.getDeviceName());
  }
}