package tests;

import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenshotUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        Locale.setDefault(Locale.US);
        extent = utilities.ExtentManager.getExtent();
    }

    @BeforeMethod
    public void setUp(Method method) {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("insiderHomePageUrl"));
        test = extent.createTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());

            if (driver != null) {
                String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
                test.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            } else {
                test.warning("Driver null → screenshot alınamadı.");
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }

        Driver.quitDriver();
        driver = null;
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (extent != null) extent.flush();
    }
}
