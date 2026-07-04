package tests;

import adapters.CaseAdapter;
import models.cases.CaseRq;
import models.cases.CaseRs;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CaseAPITest {
    private Integer id;
    private static final String PROJECT_CODE = "QA";

    @Test
    public void checkCreateCase() {
        CaseRq rq = CaseRq.builder()
                .description("test")
                .preconditions("test")
                .postconditions("test")
                .title("Test case")
                .severity(1)
                .priority(1)
                .behavior(1)
                .type(1)
                .layer(1)
                .is_flaky(1)
                .build();
        CaseRs rs = CaseAdapter.createCase(PROJECT_CODE,rq);
        Assert.assertTrue(rs.getStatus());
        id = rs.getResult().getId();
        Assert.assertNotNull(rs.getResult().getId(), "Case ID should not be null");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteCase() {
        if (id != null) {
            CaseAdapter.deleteCase(PROJECT_CODE,id);
        }
    }
}