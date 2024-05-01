import io.restassured.http.ContentType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class _01_ApiTest {

    @Test
    public void Test(){

        given()
                // hazırlık kodları buraya yazılır
        .when()
                //endpoint(url) metoduyla birlikte istek gönderilme aşaması
                .then();
                    //assertion test data işlemleri

    }

    @Test
    public void statusCodeTest(){

        given()
                    // gönderilecek bilgiler burada
                .when()
                .get("https://api.zippopotam.us/us/90210")
                .then()
                .log().body() // gelen body kısmını ver all dersek herşeyi verir
                .statusCode(200); // test kısmı assertion status 200
                ;


    }
    @Test
    public void contentTypeTest(){

        given()

                .when()
                .get("https://api.zippopotam.us/us/90210")

                .then()
                .log().body() // dönen body bilgisini göster
                .statusCode(200) // dönen kod 200 mü
                .contentType(ContentType.JSON); // dönen data tipi JSON mı

        ;


    }

    @Test
    public void chechkCountryInResponsBody(){
        given()

                .when()
                .get("https://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .statusCode(200)
                .body("country", equalTo("United States")) // countryi dışarı almadan bulunduğu yeri yani path i
                                                            // vererek içerde assertion yapmak HemCrest kütüphanesi sayesinde

        ;
    }
    // Soru : "http://api.zippopotam.us/us/90210"  endpoint indne dönen
    // place dizisinin ilk elemanının state değerinin  "California"
    // olduğunu doğrulayınız
    @Test
    public void chechkCountryInResponsBody2(){

        given()

                .when()
                .get("https://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .statusCode(200)
                .body("places[0].state", equalTo("California")) // countryi dışarı almadan bulunduğu yeri yani path i
        // vererek içerde assertion yapmak HemCrest kütüphanesi sayesinde

        ;



    }

    // Soru : "http://api.zippopotam.us/tr/01000"  endpoint in dönen
    // place dizisinin herhangi bir elemanında  "Dörtağaç Köyü" değerinin
    // olduğunu doğrulayınız

    @Test
    public void test(){


        given()
                // gönderilecek bilgiler burada
                .when()
                .get("http://api.zippopotam.us/tr/01000")
                .then()
                .log().body()
                .body("places.'place name'", hasItem("Dörtağaç Köyü")) // places içindeki place name de geçtiği için böyle ara

        ;



    }





}
