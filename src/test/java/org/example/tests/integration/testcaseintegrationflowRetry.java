package org.example.tests.integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.example.POJOS.Booking;
import org.example.POJOS.BookingResponse;
import org.example.base.Baseclass;
import org.example.endpoint.APIConstants;
import org.example.listeners.RetryAnalyzer;
import org.example.utils.propertyReader;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class testcaseintegrationflowRetry extends Baseclass{
    @Test(groups = "integration", priority = 1)
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateBooking(ITestContext iTestContext) {
        iTestContext.setAttribute("token", getToken());
        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(payloadsmanager.CreatePayloadBookingAsString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Default Assertion
        validatableResponse.body("booking.firstname", Matchers.equalTo(propertyReader.readKey("booking.post.firs")));

        BookingResponse bookingResponse = payloadsmanager.bookingResponseJava(response.asString());

        // AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(propertyReader.readKey("booking.post.firstname"));


        iTestContext.setAttribute("bookingid", bookingResponse.getBooking());

    }

    @Test(groups = "integration", priority = 2)
    @Owner("Praveen")
    @Description("TC#INT1 - Step 2. Verify that the Booking By ID")
    public void testVerifyBookingId(ITestContext iTestContext){

        // bookingId -
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String basePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathGET);

        requestSpecification.basePath(basePathGET);
        response = RestAssured
                .given(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadsmanager.getResponseFromJson(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
//        assertThat(booking.getFirstname()).isEqualTo("James");
        assertThat(booking.getFirstname()).isEqualTo(propertyReader.readKey("booking.get.firstname"));
    }

    @Test(groups = "integration", priority = 3)
    @Owner("Praveen")
    @Description("TC#INT1 - Step 3. Verify Updated Booking by ID")
    public void testUpdateBookingByID(ITestContext iTestContext){
        System.out.println("Token - " + iTestContext.getAttribute("token"));
        String token = (String) iTestContext.getAttribute("token");
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String basePathPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathPUTPATCH);


        requestSpecification.basePath(basePathPUTPATCH);
        response = RestAssured
                .given(requestSpecification).cookie("token", token)
                .when().body(payloadsmanager.fullUpdatePayloadAsString()).put();
        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadsmanager.getResponseFromJson(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo(propertyReader.readKey("booking.get.firstname"));
        assertThat(booking.getFirstname()).isEqualTo(propertyReader.readKey("booking.get.lastname"));

    }

    @Test(groups = "integration", priority = 4)
    @Owner("Praveen")
    @Description("TC#INT1 - Step 4. Delete the Booking by ID")
    public void testDeleteBookingById(ITestContext iTestContext){

        String token = (String) iTestContext.getAttribute("token");
        Assert.assertTrue(true);

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePathDELETE = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathDELETE);

        requestSpecification.basePath(basePathDELETE).cookie("token", token);
        validatableResponse = RestAssured.given().spec(requestSpecification)
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);

    }
}
