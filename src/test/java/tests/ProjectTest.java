package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage()
                .login(user, password)
                .isPageOpened()
                .createProject("TMS02", "TMS02")
                .openPage("TMS02")
                .checkProjectName("TMS02")
                .openPage()
                .deleteProject("TMS02");
    }
}
