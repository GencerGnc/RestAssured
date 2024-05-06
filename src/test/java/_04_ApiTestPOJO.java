import Model.Location;
import Model.Place;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;


public class _04_ApiTestPOJO {

    @Test
    public void extractJsonAll_POJO(){

        Location locationNesnesi=
                given()

                        .when()
                        .get("http://api.zippopotam.us/us/90210")

                        .then()
                        .extract().body().as(Location.class);
        ;

        System.out.println("locationNesnesi = " + locationNesnesi);
        System.out.println("locationNesnesi.getPlaces() = " + locationNesnesi.getPlaces());
        System.out.println("locationNesnesi.getPostcode() = " + locationNesnesi.getPostcode());


    }
    @Test
    public void Test(){

        Location locationNesnesi=

                given()

                        .when()
                        .get("http://api.zippopotam.us/tr/01000")

                        .then()
                        .extract().body().as(Location.class);
               ;

        for (int i = 0; i < locationNesnesi.getPlaces().size(); i++) {
            Place place=locationNesnesi.getPlaces().get(i);
            if (locationNesnesi.getPlaces().toString().toLowerCase().contains("dörtağaç köyü"))
                System.out.println("locationNesnesi.getPlaces() = " + place);
         return;
        }


 // 2. yöntem   ,
        for (Place p: locationNesnesi.getPlaces())
            if (p.getPlacename().equalsIgnoreCase("dörtağaç köyü"))
                System.out.println("p = " + p);
    }
}
