package com.petstore.swagger.crudtest;
import com.petstore.swagger.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class User_Get_CRUD extends TestBase {


    @Test
    public void getUserByName() {
        Response response = given()
                .pathParam("username", "SRK111")
                .when().get("{username}");


        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void getPingHealthCheck() {
        Response response = given()
                .when().get("https://petstore.swagger.io/v2");

        response.then()
                .statusCode(201);
        response.prettyPrint();

    }
}
