package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomePage extends ReusableMethods {

    @FindBy(xpath = "//div[@class='homepage-core-differentiators-body']")
    public WebElement homePageBodyItems;

    @FindBy(id = "navigation")
    public WebElement header;

    @FindBy(id = "footer")
    public WebElement footer;

    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement cookieAcceptButton;



    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void checkIfBodyItemsVisible() {
        checkIfElementVisible(homePageBodyItems);
    }

    public void checkIfHeaderVisible() {
        checkIfElementVisible(header);

    }

    public void checkIfFooterVisible() {
        checkIfElementVisible(footer);
    }

    public void clickHomePageCookieAcceptButton() {
        clickCookieAcceptButton(cookieAcceptButton);
    }

}