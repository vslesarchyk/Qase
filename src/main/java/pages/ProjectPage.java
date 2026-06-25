package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPage {
    private final String PROJECT_NAME= "h2";

    public ProjectPage checkProjectName (String projectName) {
        $(PROJECT_NAME).shouldBe(visible).shouldHave(text(projectName));
        return this;
    }

    public ProjectsPage openPage() {
        open("/projects");
         return new ProjectsPage();
    }
}
