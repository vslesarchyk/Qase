package pages;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static dict.Elements.CREATE_NEW_PROJECT_BUTTON;
import static dict.Elements.CREATE_PROJECT_BUTTON;

public class ProjectsPage {
    private final String PROJECT_NAME = "#project-name";
    private final String PROJECT_CODE = "#project-code";
    private final String REMOVE_BUTTON = "[data-testid=remove]";
    private final String DELETE_PROJECT_BUTTON = "//span[text()='Delete project']";
    private final String ACTION_MENU = "button[aria-label='Open action menu']";
    private final String TABLE_ROW = "tr";

    public ProjectsPage isPageOpened() {
        open("/projects");
        return this;
    }

    public ProjectsPage createProject(String projectName, String projectCode) {
        $(byText(CREATE_NEW_PROJECT_BUTTON)).click();
        $(PROJECT_NAME).setValue(projectName);
        $(PROJECT_CODE).setValue(projectCode);
        $(byText(CREATE_PROJECT_BUTTON)).click();
        return this;
    }

    public ProjectsPage deleteProject(String project) {
        $(byText(project))
                .ancestor(TABLE_ROW)
                .find(ACTION_MENU)
                .click();
        $(REMOVE_BUTTON).click();
        $x(DELETE_PROJECT_BUTTON).click();
        return this;
    }

    public ProjectPage openPage(String projectName) {
        open("/project/" + projectName);
        return new ProjectPage();
    }
}