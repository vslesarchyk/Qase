package adapters;
import models.cases.CaseRq;
import models.cases.CaseRs;
import static adapters.BaseAdapter.ok200;
import static adapters.BaseAdapter.spec;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CaseAdapter {
    public static CaseRs createCase(String projectCode, CaseRq rq) {
        return given()
                .spec(spec)
                .pathParam("code", projectCode)
                .body(rq)
                .log().all()
                .when()
                .post("/case/{code}")
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/create_case_schema.json"))
                .log().all()
                .spec(ok200)
                .extract()
                .as(CaseRs.class);
    }

     public static void deleteCase (String projectCode, int id) {
        given()
                .spec(spec)
                .pathParam("code", projectCode)
                .pathParam("id", id)
                .log().all()
                .when()
                .delete("/case/{code}/{id}")
                .then()
                .log().all()
                .spec(ok200);
     }
}
