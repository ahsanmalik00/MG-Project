package org.circadia.pageObjects.MGMobileAppPages.AlertSummaryScreenModule;

import static org.circadia.generalizedOperations.configloader.JsonUtils.getValue;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.ALERT_SUMMARY_TEST_DATA;

public class AlertSummaryScreenTestData {
    public static final String clinicalAlertText = getValue("clinicalAlertText", ALERT_SUMMARY_TEST_DATA);
    public static final String bedExitAlertText = getValue("bedExitAlertText", ALERT_SUMMARY_TEST_DATA);
}
