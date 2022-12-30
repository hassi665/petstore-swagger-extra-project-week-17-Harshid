package com.petstore.swagger.crudtest;

import com.petstore.swagger.model.PetBodyDataPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Pet_Post_CRUD {

    public static String basePath;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";
    }

    @Test
    public void createPet() {

        PetBodyDataPojo.CategoryData categoryData = new PetBodyDataPojo.CategoryData(123, "Pub");

        ArrayList<String> photoList = new ArrayList<>();
        photoList.add("Photo of pub breed");

        ArrayList < PetBodyDataPojo.TagData> tagDataList = new ArrayList<>();
        PetBodyDataPojo.TagData tagData = new PetBodyDataPojo.TagData(120, "Black and White spots");
        tagDataList.add(tagData);

        PetBodyDataPojo petBodyDataPojo = new PetBodyDataPojo();
        petBodyDataPojo.setId(1122334457);
        petBodyDataPojo.setCategory(categoryData);
        petBodyDataPojo.setName("Puppy");
        petBodyDataPojo.setPhotoUrls(photoList);
        petBodyDataPojo.setTags(tagDataList);
        petBodyDataPojo.setStatus("Not available");


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(petBodyDataPojo)
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().log().all().statusCode(200);


    }
}
