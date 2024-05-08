package GoRest;
import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class GoRestUsersTest {
    //Token ı al
    //usersCreate için neler lazım body(user bilgileri)
    //endpointi aldım gidiş metodu
    // beforeclassın içinde yapılacaklar var mı? nelerdir?


    RequestSpecification reqSpec;

    Faker randomUreteci = new Faker();
    String rndFullName="";
    String rndEmail="";

    int userID=0;

    @BeforeClass
    public void Setup() {

        {
            baseURI = "https://gorest.co.in/public/v2/users";

            reqSpec = new RequestSpecBuilder()
                    .addHeader("Authorization", "Bearer a0f97980b854a4e09a214dfe1824e4917072ca70d1ba8bd980d5ba42d08f71f3")
                    .setContentType(ContentType.JSON)
                    .build();
        }

    }

    @Test
    public void CreateUser(){
       rndFullName= randomUreteci.name().fullName();
         rndEmail= randomUreteci.internet().emailAddress();

        Map<String,String> newUser=new HashMap<>();
        newUser.put("name",rndFullName);
        newUser.put("gender","male");
        newUser.put("email",rndEmail);
        newUser.put("status","active");

        userID=
                given()
                        .spec(reqSpec)
                        .body(newUser)

                        .when()
                        .post("")// http ile başlamıyorsa BASEURI geçerli

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().path("id")
        ;




    }

    @Test(dependsOnMethods = "CreateUser")
    public void GetUserById(){


        given()
                .spec(reqSpec)

                .when()
                .get("/"+userID)

                .then()
                .statusCode(200)
                .body("id",equalTo(userID))

        ;

    }

    @Test(dependsOnMethods = "GetUserById")
    public void UpdateUser(){

        String updUserName="BOB";

        Map<String,String> UpdatenewUser=new HashMap<>();
       UpdatenewUser.put("name",updUserName);


                given()
                        .spec(reqSpec)
                        .body(UpdatenewUser)

                        .when()
                        .put("/"+userID)// http ile başlamıyorsa BASEURI geçerli

                        .then()
                        .log().body()
                        .statusCode(200)
                        .body("name", equalTo(updUserName))
        ;

    }


}