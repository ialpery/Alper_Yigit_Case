package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class LeverPage extends ReusableMethods {

    @FindBy(xpath = "//body[@class='show header-comfortable']")
    public WebElement pageBody;

    public LeverPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void checkIfCurrentPageIsLeverPage() {
        checkIfUrlCorrect("https://jobs.lever.co/insiderone");
    }

    public void waitUntilLeverPageBodyLoad() {
        waitUntilElementVisible(pageBody);
    }
}
