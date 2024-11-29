package org.circadia.testHelpers.listeners;

import org.circadia.generalizedOperations.customannotations.FrameworkAnnotation;
import org.circadia.generalizedOperations.reports.ExtentReportLogger;
import org.circadia.generalizedOperations.reports.ExtentReportManager;
import org.testng.*;

public class Listeners implements ITestListener, ISuiteListener {

  @Override
  public void onStart(ISuite suite) {
    ExtentReportManager.initExtentReport();
  }

  @Override
  public void onTestStart(ITestResult result) {
    ExtentReportManager.createTest(result.getMethod().getMethodName());
    ExtentReportManager.addAuthors(
      result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
    ExtentReportManager.addCategories(
      result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    ExtentReportManager.addDevices();
    ExtentReportLogger.logInfo("Test Description - <b>" + result.getMethod().getDescription() +"</b>");
    ExtentReportLogger.logInfo("Test - <b>" + result.getMethod().getMethodName() + "</b> is started");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    ExtentReportLogger.logPass("Test - <b>" + result.getMethod().getMethodName() + "</b> is passed");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    ExtentReportLogger.logFail("Test - <b>" + result.getMethod().getMethodName() + "</b> is failed", result.getThrowable());
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    ExtentReportLogger.logSkip("Test - <b>" + result.getMethod().getMethodName() + "</b> is skipped");
  }

  @Override
  public void onFinish(ISuite suite) {
    ExtentReportManager.flushExtentReport();
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // No implementation
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    // No implementation
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    // No implementation
  }
}
