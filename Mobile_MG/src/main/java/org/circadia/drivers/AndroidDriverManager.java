package org.circadia.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.circadia.generalizedOperations.customexceptions.DriverInitializationException;
import org.circadia.generalizedOperations.enums.ConfigJson;

import java.time.Duration;

import static org.circadia.generalizedOperations.configloader.JsonUtils.getConfig;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.ANDROID_APK_PATH;
import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.*;
import static org.circadia.server.AppiumServerManager.*;

public class AndroidDriverManager {

    private static final ThreadLocal < AndroidDriver > DRIVER = new ThreadLocal < > ();
    public static void quitSession() {
        if (null != DRIVER.get()) {
            getDriver().quit();
            DRIVER.remove();
            stopServer();
        }
    }
    public static AndroidDriver getDriver() {
        return AndroidDriverManager.DRIVER.get();
    }
    private static void setDriver(AndroidDriver driver) {
        AndroidDriverManager.DRIVER.set(driver);
    }
    private static UiAutomator2Options uiAutomator2OptionsWdio() {
        try {
            UiAutomator2Options uiAutomator2Options;
            uiAutomator2Options = new UiAutomator2Options()
                    .setAvdLaunchTimeout(Duration.ofSeconds(AVD_LAUNCH_TIMEOUT))
                    .setAvdReadyTimeout(Duration.ofSeconds(AVD_READY_TIMEOUT))
                    .setDeviceName(getDeviceName())
                    .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                    .setApp(ANDROID_APK_PATH + getConfig(ConfigJson.APK_NAME))
                    .setPlatformVersion(getConfig(ConfigJson.ANDROID_VERSION))
                    .setAutoGrantPermissions(true)
                    .setAppPackage(getAppPackage())
                    .setAppActivity(getAppMainActivity())
                    .setNoReset(false);
            return uiAutomator2Options;
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
        }
    }
    private static UiAutomator2Options uiAutomator2OptionsChrome() {
        try {
            UiAutomator2Options uiAutomator2Options;
            uiAutomator2Options = new UiAutomator2Options()
                    .setAvd(getConfig(ConfigJson.AVD_NAME))
                    .setAvdLaunchTimeout(Duration.ofSeconds(AVD_LAUNCH_TIMEOUT))
                    .setAvdReadyTimeout(Duration.ofSeconds(AVD_READY_TIMEOUT))
                    .setDeviceName(getDeviceName())
                    .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                    .withBrowserName(getConfig(ConfigJson.BROWSER_CHROME))
                    .setAutoGrantPermissions(true)
                    .setNoReset(false);
            return uiAutomator2Options;
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
        }
    }
    public static void createAndroidDriver() {
        startServer(getPlatformName());
        setDriver(new AndroidDriver(getService().getUrl(), uiAutomator2OptionsWdio()));
        setupDriverTimeouts();
    }
    private static void setupDriverTimeouts() {
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(50));
    }
}