import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @BeforeMethod
    public void startUp() {

    }

    @Test
    public void firstTest() {
        RestAssured.baseURI = "http://www.omdbapi.com";

        RequestSpecBuilder build = new RequestSpecBuilder();
        build.addParam("apikey", "c0db11a4");

        given().spec(build.build())
                .when().
                get("/?t=matrix").
                then().
                statusCode(200).
                body("Title", equalTo("Matrix"),
                        "Year", equalTo("1993"),
                        "Ratings[0].Source", equalTo("Internet Movie Database"));
    }
}
