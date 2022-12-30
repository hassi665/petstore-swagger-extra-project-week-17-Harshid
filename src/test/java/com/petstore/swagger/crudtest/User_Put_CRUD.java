package com.petstore.swagger.crudtest;

import com.petstore.swagger.model.UpdateBodyDataPojo;
import com.petstore.swagger.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class User_Put_CRUD extends TestBase {


    @Test
    public void updateUserModify() {

        UpdateBodyDataPojo updateBodyDataPojo = new UpdateBodyDataPojo();

        updateBodyDataPojo.setId(8678);
        updateBodyDataPojo.setUsername("SRK007");
        updateBodyDataPojo.setFirstname("Hardik");
        updateBodyDataPojo.setLastname("Kumar");
        updateBodyDataPojo.setEmail("srk.king121@gmail.com");
        updateBodyDataPojo.setPassword("SRK@1234");
        updateBodyDataPojo.setPhone("07418529630");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(updateBodyDataPojo)
                .put("https://petstore.swagger.io/v2/user/SRK007");
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }
}
