package org.circadia.server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.circadia.generalizedOperations.customexceptions.DriverInitializationException;

import java.io.File;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;
import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.*;
import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.getAppiumServerLogsPath;

public class AppiumServerManager {
    public static AppiumDriverLocalService service;
    public static void startServer(String platformName) {
        try {
            AppiumServiceBuilder builder = new AppiumServiceBuilder();
            if (platformName.equalsIgnoreCase(getPlatformName())) {

                builder.withIPAddress(APPIUM_SERVER_HOST)
                        .usingPort(APPIUM_SERVER_PORT)
                        .usingAnyFreePort()
                        .withAppiumJS(new File(APPIUM_JS_PATH))
                        .usingDriverExecutable(new File(NODEJS_PATH))
                        .withArgument(BASEPATH, URL_POSTFIX)
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, LOG_LEVEL_NAME)
                        .withArgument(USE_DRIVERS, DRIVER_UIAUTOMATOR)
                        .withArgument(ALLOW_INSECURE, DRIVER_CHROME_AUTO_DOWNLOAD)
                        .withLogFile(new File(getAppiumServerLogsPath()));
            } else if (platformName.equalsIgnoreCase(DEVICE_IOS)) {
                builder.withIPAddress(APPIUM_SERVER_HOST).usingPort(APPIUM_SERVER_PORT)
                        .withArgument(BASEPATH, URL_POSTFIX)
                        .withArgument(LOG_LEVEL, LOG_LEVEL_NAME)
                        .withArgument(USE_DRIVERS, DRIVER_XCTEST)
                        .withArgument(ALLOW_INSECURE, DRIVER_CHROME_AUTO_DOWNLOAD);
            }
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to start appium server.", e);
        }
    }
    public static AppiumDriverLocalService getService() {
        return service;
    }
    public static void stopServer() {
        service.stop();
    }
}