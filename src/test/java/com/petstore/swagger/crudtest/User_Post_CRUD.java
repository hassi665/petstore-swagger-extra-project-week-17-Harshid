package com.petstore.swagger.crudtest;

import com.petstore.swagger.model.BodyDataPojo;
import com.petstore.swagger.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class User_Post_CRUD extends TestBase {



    @Test
    public void createUser() {

        BodyDataPojo bodyDataPojo = new BodyDataPojo();
        bodyDataPojo.setId(86789);
        bodyDataPojo.setUsername("SRK007");
        bodyDataPojo.setFirstname("Sahrukh");
        bodyDataPojo.setLastname("Pathan");
        bodyDataPojo.setEmail("srk.king@gmail.com");
        bodyDataPojo.setPassword("SRK@123");
        bodyDataPojo.setPhone("07418529630");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(bodyDataPojo)
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }

}

