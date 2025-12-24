package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QaPage extends ReusableMethods {

    private WebDriver driver;

    @FindBy( xpath = "//a[text()='See all QA jobs']")
    public WebElement seeAllQaJobsButton;

    public QaPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateQaPage() {
        Driver.getDriver().get(ConfigReader.getProperty("insiderQaPageUrl"));
    }

    public void clickSeeAllQaJobsButton() {
        waitAndClickElement(seeAllQaJobsButton);
    }
}
