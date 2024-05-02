import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class _03_ApiTestExtract {

    @Test
    public void extractingJsonPath(){

        String ulkeAdi=given().when().get("https://api.zippopotam.us/us/90210").then().extract().path("country");

        System.out.println("ulkeAdi = " + ulkeAdi);
        Assert.assertEquals(ulkeAdi, "United States");


    }

    // Soru : "http://api.zippopotam.us/us/90210"  endpoint indne dönen
    // place dizisinin ilk elemanının state değerinin  "California"
    // olduğunu testNG Assertion ile doğrulayınız
    @Test
    public void extractingJsonPath2(){

        String ulkeAdi2=
                given()

                        .when()
                        .get("https://api.zippopotam.us/us/90210")

                        .then()
                        .extract().path("places[0].state");


        System.out.println("ulkeAdi2 = " + ulkeAdi2);
        Assert.assertEquals(ulkeAdi2, "California");


    }
    // Soru : "http://api.zippopotam.us/us/90210"  endpoint indne dönen
    // place dizisinin ilk elemanının place name değerinin  "Beverly Hills"
    // olduğunu testNG Assertion ile doğrulayınız
    @Test
    public void extractingJsonPath3(){
        String ulkeAdi3=
                given()

                        .when()
                        .get("https://api.zippopotam.us/us/90210")

                        .then()
                        .extract().path("places[0].'place name'");


        System.out.println("ulkeAdi3 = " + ulkeAdi3);
        Assert.assertEquals(ulkeAdi3, "Beverly Hills");
    }
    // Soru : "https://gorest.co.in/public/v1/users"  endpoint in den dönen
    // limit bilgisinin 10 olduğunu testNG ile doğrulayınız.
    @Test
    public void extractingJsonPath4(){
        int limit= //strin limit diyip .extract().path("meta.pagination.limit").toSting diyede yapılır
        given()

                .when()
                .get("https://gorest.co.in/public/v1/users")

                .then()
                .extract().path("meta.pagination.limit")

        ;System.out.println("limit = " + limit);
            Assert.assertTrue(limit==10);

    }

    @Test
    public void extractingJsonPath5(){
        List<Integer> idler=
        given()

                .when()
                .get("https://gorest.co.in/public/v1/users")

                .then()
                .log().body()
                .extract().path("data.id")
                ;
        System.out.println("idler = " + idler);
    }
    // Soru : "https://gorest.co.in/public/v1/users"  endpoint in den dönen
    // bütün name leri yazdırınız.
    @Test
    public void extractingJsonPath6(){
        List<String> names=
                given()

                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        .log().body()
                        .extract().path("data.name")
                ;
        System.out.println("names = " + names);

    }
    @Test
    public void extractingJsonPathResponsAll(){

        Response donendata= //pm.Response.Json
                given()

                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        .log().body() // hepsini yazdırmak için bodynin yani linkin
                        .extract().response()
                ;
        List<Integer> idler=donendata.path("data.id");
        List<String> names=donendata.path("data.name");
        int limit=donendata.path("meta.pagination.limit");

        System.out.println("idler = " + idler);
        System.out.println("names = " + names);
        System.out.println("limit = " + limit);

        Assert.assertTrue(idler.contains(6880125));
        Assert.assertTrue(names.contains("Karunanidhi Jain"));
        Assert.assertTrue(limit==10);
    }

}
