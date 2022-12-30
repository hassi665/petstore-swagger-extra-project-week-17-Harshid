package com.petstore.swagger.crudtest;

import com.petstore.swagger.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class User_Delete_CRUD extends TestBase {

    @Test
    public void getDeleteUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("username", "SRK123")
                .when().delete("{username}");

        response.then().statusCode(200);
        response.prettyPrint();
        System.out.println("Record Deleted");
    }
}
