package com.petstore.swagger.crudtest;

import com.petstore.swagger.model.PetBodyDataPojo;
import com.petstore.swagger.model.UpdateBodyDataPojo;
import com.petstore.swagger.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Pet_Put_CRUD extends TestBase {


    @Test
    public void updateCurrentPet() {

        PetBodyDataPojo.CategoryData categoryData = new PetBodyDataPojo.CategoryData(123, "Pub");

        ArrayList<String> photoList = new ArrayList<>();
        photoList.add("Photo of pub breed");

        ArrayList < PetBodyDataPojo.TagData> tagDataList = new ArrayList<>();
        PetBodyDataPojo.TagData tagData = new PetBodyDataPojo.TagData(120, "Black and White spots");
        tagDataList.add(tagData);

        PetBodyDataPojo petBodyDataPojo = new PetBodyDataPojo();
        petBodyDataPojo.setId(1122334456);
        petBodyDataPojo.setCategory(categoryData);
        petBodyDataPojo.setName("Puppy123");
        petBodyDataPojo.setPhotoUrls(photoList);
        petBodyDataPojo.setTags(tagDataList);
        petBodyDataPojo.setStatus("Shortly Available");



        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(petBodyDataPojo)
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }
}
