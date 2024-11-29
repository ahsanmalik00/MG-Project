package org.circadia.testHelpers.alertsAPI;

import static io.restassured.RestAssured.given;
import static org.circadia.pageObjects.MGMobileAppPages.BedExitAlertsModule.BedExitTestData.*;

public class BedExitAlertApis {

    public void sendBedExitAlert(String url){
        System.out.println("calling api");
        given()
                .auth().basic(API_USERNAME,API_PASSWORD)
                .when()
                .get(url)
                .then().statusCode(200);

        System.out.println("api call end");
    }
}
