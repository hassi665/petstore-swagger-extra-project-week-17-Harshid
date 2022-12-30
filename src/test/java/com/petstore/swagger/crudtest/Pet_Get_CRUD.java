package com.petstore.swagger.crudtest;

import com.petstore.swagger.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Pet_Get_CRUD {

    public static String basePath;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";
    }

    @Test
    public void findPetById() {
        Response response = given()
                .pathParam("id", "112233445")
                .when().get("{id}");


        response.then().statusCode(200);
        response.prettyPrint();
    }

}
