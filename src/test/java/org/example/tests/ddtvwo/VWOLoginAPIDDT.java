package org.example.tests.ddtvwo;

import org.example.utils.utilsExcel;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class VWOLoginAPIDDT {

    RequestSpecification r2;
    ValidatableResponse vR2;
    Integer ID;
    Response res2;

    @Test(dataProvider = "getData",dataProviderClass = utilsExcel.class)
    public void testVWOLogin(String email, String password) {
        System.out.println(" -- Login API Testing");
        System.out.println(email);
        System.out.println(password);

    }

}
