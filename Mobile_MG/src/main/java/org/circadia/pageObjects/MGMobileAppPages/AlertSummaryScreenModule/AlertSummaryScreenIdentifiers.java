package org.circadia.pageObjects.MGMobileAppPages.AlertSummaryScreenModule;

import static org.circadia.generalizedOperations.configloader.JsonUtils.getValue;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.ALERT_SUMMARY_IDENTIFIERS;

public class AlertSummaryScreenIdentifiers {
    public static final String listOfRooms = getValue("listOfRooms", ALERT_SUMMARY_IDENTIFIERS);
    public static final String textOnAlertCard = getValue("textOnAlertCard", ALERT_SUMMARY_IDENTIFIERS);
}

