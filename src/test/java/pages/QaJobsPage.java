package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class QaJobsPage extends ReusableMethods {

    @FindBy(id = "filter-by-location")
    public WebElement locationDropdown;

    @FindBy(id = "filter-by-department")
    public WebElement departmentDropdown;

    @FindBy(css = "#jobs-list > div")
    public List<WebElement> jobList;

    @FindBy(css = ".position-department")
    public List<WebElement> positionsDepartments;

    @FindBy(css = ".position-location")
    public List<WebElement> positionsLocations;

    @FindBy(xpath = "//a[text()='View Role']")
    public WebElement viewRoleButton;

    public QaJobsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void selectLocation(String location) {
        selectByVisibleText(locationDropdown, location);
    }

    public void selectDepartment(String department) {
        selectByVisibleText(departmentDropdown, department);
    }

    public void checkIfPositionLocationsCorrect() {
        waitUntilAllElementsHaveAttribute(
                jobList,
                "data-location",
                "istanbulturkiye",
                15
        );

        waitUntilAllElementsHaveText(
                positionsLocations,
                "Istanbul, Turkiye",
                15
        );

        jobList.forEach(job ->
                Assert.assertEquals(job.getAttribute("data-location"), "istanbulturkiye")
        );

        positionsLocations.forEach(dep ->
                Assert.assertEquals(dep.getText().trim(), "Istanbul, Turkiye")
        );
    }

    public void checkIfPositionDepartmentsCorrect() {

        waitUntilAllElementsHaveAttribute(
                jobList,
                "data-team",
                "qualityassurance",
                15
        );

        waitUntilAllElementsHaveText(
                positionsDepartments,
                "Quality Assurance",
                15
        );

        jobList.forEach(job ->
                Assert.assertEquals(job.getAttribute("data-team"), "qualityassurance")
        );

        positionsDepartments.forEach(dep ->
                Assert.assertEquals(dep.getText().trim(), "Quality Assurance")
        );
    }


    public void clickViewRoleButton() {
        waitAndClickElement(viewRoleButton);
        switchNewTab();
    }

    public void waitUntilJobsListLoaded() {
        waitUntilElementVisible(viewRoleButton);
    }
}
