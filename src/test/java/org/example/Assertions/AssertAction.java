package org.example.Assertions;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssertAction {

    // Common Assertion will be here

    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(int actual, int expected, String description){
        assertEquals(actual, expected, description);
    }

    public void vstatuscode(Response response, Integer expected){
        assertEquals(response.getStatusCode(), expected);
    }
}
