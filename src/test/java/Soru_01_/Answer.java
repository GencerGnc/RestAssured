package Soru_01_;
import Model.Location;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Answer {


    @Test
    public void Test(){


        given()


                .when()
                .get("http://api.zippopotam.us/tr/01000")

                .then()
                .log().body()









        ;



    }






}
