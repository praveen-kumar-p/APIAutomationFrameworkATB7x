package org.example.tests.CRUD;

import groovy.beans.PropertyReader;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.qameta.allure.Description;
import org.example.POJOS.BookingResponse;
import org.example.base.Baseclass;
import org.example.endpoint.APIConstants;
import org.example.utils.propertyReader;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import static org.assertj.core.api.Assertions.*;

public class testcasecreatepost extends Baseclass{

    @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
    @Issue("JIRA_RBT-4")
    @TmsLink("RBT-4")
    @Owner("Promode")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that POST request is working fine.")
    @Test
    public void testVerifyCreateBookingPOST01() {
        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(payloadsmanager.CreatePayloadBookingAsString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(Integer.parseInt(propertyReader.readKey("booking.post.statuscode.success")));

        //Default Rest Assured
        validatableResponse.body("booking.firstname", Matchers.equalTo(propertyReader.readKey("booking.post.firstname")));

        BookingResponse bookingResponse = payloadsmanager.bookingResponseJava(response.asString());

        // AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(propertyReader.readKey("booking.post.firstname"));

        // TestNG Assertions
        assertaction.verifyStatusCode(response, 200);
    }
}
 //your code is working good