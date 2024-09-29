package org.example.tests.CRUD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.qameta.allure.*;
import org.example.POJOS.bookingresponse;
import org.example.base.BaseTest;
import org.example.endpoint.APIConstants;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestCreatebookingpost extends BaseTest {


//    @Link(name= "Link to TC", url = "")

    @Description("Verify that post request is working fine")
    @Test
    public void testcreatepost01 (){

        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createpayloadbooking()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Default Rest Assured
        validatableResponse.body("booking.firstname", Matchers.equalTo("James"));


        bookingresponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        // AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull().isNotZero();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotEmpty().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James");
        validatableResponse.statusCode(200);

    }
}
