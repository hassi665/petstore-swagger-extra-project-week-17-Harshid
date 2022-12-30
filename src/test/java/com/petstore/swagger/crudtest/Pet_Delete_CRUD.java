package com.petstore.swagger.crudtest;

import com.petstore.swagger.model.PetBodyDataPojo;
import com.petstore.swagger.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Pet_Delete_CRUD{

   /* public static String basePath;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";
    }
*/
    @Test
    public void apiKey() {

        PetBodyDataPojo petBodyDataPojo = new PetBodyDataPojo();

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body(petBodyDataPojo)
                .delete("https://petstore.swagger.io/v2/pet/1122334457");

        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

}
