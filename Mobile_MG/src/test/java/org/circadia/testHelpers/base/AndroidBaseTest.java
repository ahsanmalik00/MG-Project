package org.circadia.testHelpers.base;

import org.circadia.generalizedOperations.commonActions.WebPortalActions;
import org.circadia.generalizedOperations.reports.ExtentReportManager;
import org.circadia.generalizedOperations.screenrecording.ScreenRecordingService;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.circadia.drivers.AndroidDriverManager.createAndroidDriver;
import static org.circadia.drivers.AndroidDriverManager.quitSession;

public class AndroidBaseTest extends WebPortalActions {
    @BeforeSuite(alwaysRun = true)
    public void testSetupSuite(ITestContext context){
        createAndroidDriver();
    }
    @BeforeMethod(alwaysRun = true)
    public void testSetupMethod() {
//        ScreenRecordingService.startRecording();
    }
    @BeforeMethod(alwaysRun = true)
    protected void tearDownTest(ITestResult result) {
//        String fullClassName = result.getTestClass().getName();
//        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
//        ScreenRecordingService.stopRecording(className, result.getMethod().getMethodName());
    }
    @AfterSuite(alwaysRun = true)
    protected void tearDownSuite() {
        quitSession();
    }
}