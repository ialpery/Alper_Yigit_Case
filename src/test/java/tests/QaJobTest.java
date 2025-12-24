package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeverPage;
import pages.QaJobsPage;
import pages.QaPage;

public class QaJobTest extends BaseTest {
    HomePage homePage = new HomePage();
    QaPage qaPage = new QaPage();
    QaJobsPage qaJobsPage = new QaJobsPage();
    LeverPage leverPage = new LeverPage();

    @Test
    public void QaJobFilterTest() throws InterruptedException {

        test.info("Navigated to the site");
        homePage.checkIfHeaderVisible();
        test.pass("Header is visible");

        homePage.checkIfBodyItemsVisible();
        test.pass("Main blocks are visible");

        homePage.checkIfFooterVisible();
        test.pass("Footer is visible");


        homePage.clickHomePageCookieAcceptButton();
        test.pass("Clicked to accept button of the homepage cookie modal");


        qaPage.navigateQaPage();
        test.info("Navigated to the Qa page");

        qaPage.clickSeeAllQaJobsButton();
        test.pass("Clicked to the See All QA Jobs button");

        qaJobsPage.selectDepartment("Quality Assurance");
        test.pass("Department selected" );

        qaJobsPage.selectLocation("Istanbul, Turkiye");
        test.pass("Location selected" );

        qaJobsPage.waitUntilJobsListLoaded();
        test.info("Job list loaded" );

        qaJobsPage.checkIfPositionLocationsCorrect();
        test.pass("Jobs Locations are correct" );


        qaJobsPage.checkIfPositionDepartmentsCorrect();
        test.pass("Jobs Departments are correct" );

        qaJobsPage.clickViewRoleButton();
        test.pass("Clicked to the view role button" );

        leverPage.waitUntilLeverPageBodyLoad();
        test.pass("Lever Page body loaded" );

        leverPage.checkIfCurrentPageIsLeverPage();
        test.pass("Current page is Lever Page" );


    }
}
