package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage()
                .login("test@gmail.com", "r@a6sGZ7@vsn3wh")
                .isPageOpened()
                .createProject("TMS02", "TMS02")
                .openPage("TMS02")
                .checkProjectName("TMS02")
                .openPage()
                .deleteProject("TMS02");
    }
}
