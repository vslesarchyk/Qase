package tests;

import adapters.ProjectAdapter;
import models.project.ProjectRq;
import models.project.ProjectRs;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectAPITest {

    private final String CODE = "QA";

    @Test
    public void checkCreateProject() {
        ProjectRq rq = ProjectRq.builder()
                .title("QA34")
                .code(CODE)
                .description("test")
                .access("all")
                .group("test")
                .build();
        ProjectRs rs = ProjectAdapter.сreateProject(rq);
        Assert.assertTrue(rs.status);
        Assert.assertEquals(rs.result.code, "QA");
    }

//    @AfterMethod
//    public void deleteProject() {
//        ProjectAdapter.deleteProject(CODE);
//    }
}
