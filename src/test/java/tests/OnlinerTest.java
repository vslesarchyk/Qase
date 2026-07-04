package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static java.lang.Math.log;
import static org.hamcrest.Matchers.equalTo;

public class OnlinerTest {

    @Test
    public void checkWeatherOnliner() {
        when()
                .get("https://profile.onliner.by/sdapi/pogoda/api/now")
                .then()
                .log().all()
                .statusCode(200)
                .body("city", equalTo("Минске"))
                .body("temperature", equalTo("+23"))
                .body("icon", equalTo("A7"));
    }

    @Test
    public void checkLogin() {
        given()
                .contentType(ContentType.JSON)
                .body("{\n"+
                        "\"page\": \"https://pogoda.onliner.by/\", \n"+
                "\"login\":\"\", \n" +
                "\"password\": \"Test\"\n" +
                "}")
                .log().all()
                .when()
                .post("https://profile.onliner.by/sdapi/user.api/login")
                .then()
                .log().all()
                .statusCode(422);
    }
}

//2e4e97995f4c9ad7e9cedb200c888d0a401039d07cd7b95b1c360e59e3db809b