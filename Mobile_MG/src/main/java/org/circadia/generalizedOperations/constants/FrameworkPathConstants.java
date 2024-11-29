package org.circadia.generalizedOperations.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.circadia.generalizedOperations.configloader.JsonUtils;
import org.circadia.generalizedOperations.enums.ConfigJson;

import java.io.File;

import static org.circadia.generalizedOperations.configloader.JsonUtils.getConfig;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FrameworkPathConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String TEST_RESOURCES_DIR = PROJECT_PATH + File.separator + "src/test/resources";
    public static final String ELEMENT_SCREENSHOT_DIR = PROJECT_PATH + File.separator + "element-screenshots";
    public static final String ANDROID_APK_PATH =
            TEST_RESOURCES_DIR + File.separator + "app" + File.separator ;
    public static final String CONFIG_PROPERTIES_PATH =
            TEST_RESOURCES_DIR + File.separator + "config" + File.separator + "config.properties";
    public static final String ENV_FILE_DIR = TEST_RESOURCES_DIR + File.separator + "config";
    public static final String CONFIG_JSON_PATH =
            TEST_RESOURCES_DIR + File.separator + "config" + File.separator + "config.json";
    public static final String TEST_ASSETS_FILEPATH =
            TEST_RESOURCES_DIR + File.separator + "testAssets";
    public static final String TEST_ASSETS_FILEPATH_WEB =
            TEST_ASSETS_FILEPATH + File.separator + "webPortalPages";
    public static final String TEST_ASSETS_FILEPATH_CPRO =
            TEST_ASSETS_FILEPATH + File.separator + "cProMobileAppPages";
    public static final String LOGIN_WRONG_CREDENTIALS_TEST_DATA_FILEPATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "loginModuleTestAssets//loginWrongCredentials.json";
    public static final String LOGIN_MODULE_TEST_DATA =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "loginModuleTestAssets//loginModuleTestData.json";
    public static final String LOGIN_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "loginModuleTestAssets//loginModuleIdentifiers.json";
    public static final String BED_EXIT_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "bedExitModuleTestAssets//bedExitModuleIdentifiers.json";
    public static final String BED_EXIT_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "bedExitModuleTestAssets//bedExitModuleTestData.json";
    public static final String SETTINGS_MODULE_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "settingsModuleTestAssets//settingsModuleIdentifiers.json";
    public static final String SETTINGS_MODULE_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "settingsModuleTestAssets//settingsModuleTestData.json";
    public static final String CLINICAL_ALERT_TAB_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "clinicalAlertTabTestAssets//clinicalAlertTabIdentifiers.json";
    public static final String CLINICAL_ALERT_TAB_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "clinicalAlertTabTestAssets//clinicalAlertTabTestData.json";
    public static final String DAILY_REPORT_MODULE_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "dailyReportModuleTestAssets//dailyReportModuleIdentifiers.json";
    public static final String FLASHING_CLINICAL_ALERTS_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "flashingClinicalAlertsTestAssets//flashingClinicalAlertsIdentifiers.json";
    public static final String FLASHING_CLINICAL_ALERTS_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "flashingClinicalAlertsTestAssets//flashingClinicalAlertsTestData.json";
    public static final String RESIDENT_DIRECTORY_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "residentDirectoryModuleTestAssets//residentDirectoryModuleIdentifiers.json";
    public static final String RESIDENT_DIRECTORY_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "residentDirectoryModuleTestAssets//residentDirectoryModuleTestData.json";
    public static final String SAFETY_NET_DASHBOARD_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "safetyNetDashboardModuleTestAssets//safetyNetDashboardModuleIdentifiers.json";
    public static final String SAFETY_NET_DASHBOARD_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "safetyNetDashboardModuleTestAssets//safetyNetDashboardModuleTestData.json";
    public static final String LOGIN_WEB_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_WEB + File.separator + "loginModuleWebTestAssets//loginModuleWebIdentifiers.json";
    public static final String CLINICAL_ALERT_WEB_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_WEB + File.separator + "clinicalAlertsWebTestAssets//clinicalAlertsWebIdentifiers.json";
    public static final String WEB_PORTAL_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_WEB + File.separator + "clinicalAlertsWebTestAssets//webPortalTestData.json";
    public static final String FACE_SHEET_PATH =
            TEST_ASSETS_FILEPATH_WEB + File.separator + "clinicalAlertsWebTestAssets//sample.pdf";
    public static final String OFFLINE_ROOM_TEST_DATA_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "offlineRoomsModuleTestAssets//offlineRoomsModuleTestData.json";
    public static final String OFFLINE_ROOM_IDENTIFIERS_PATH =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "offlineRoomsModuleTestAssets//offlineRoomsModuleIdentifiers.json";
    public static final String ALERT_SUMMARY_IDENTIFIERS =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "AlertSummaryScreenModuleTestAssets//alertSummaryScreenIdentifiers.json";
    public static final String ALERT_SUMMARY_TEST_DATA =
            TEST_ASSETS_FILEPATH_CPRO + File.separator + "AlertSummaryScreenModuleTestAssets//alertSummaryScreenTestData.json";

}