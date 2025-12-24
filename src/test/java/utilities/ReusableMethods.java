package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

import java.util.List;

public class ReusableMethods {

    WebDriver driver;

    protected void selectByVisibleText(WebElement element, String text) {
        new Select(element)
                .selectByVisibleText(text);
    }

    protected void waitAndClickElement(WebElement element) {
        waitUntilElementVisible(element);
        element.click();
    }

    protected boolean checkIfElementVisible(WebElement element) {
      return element.isDisplayed();
    }

    public void waitUntilAllElementsHaveAttribute(
            List<WebElement> elements,
            String attributeName,
            String expectedValue,
            int timeoutSeconds
    ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        wait.until(driver -> elements.stream()
                .allMatch(el -> expectedValue.equals(el.getAttribute(attributeName))));
    }

    public void waitUntilAllElementsHaveText(
            List<WebElement> elements,
            String expectedText,
            int timeoutSeconds
    ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        wait.until(driver -> elements.stream()
                .allMatch(el -> expectedText.equals(el.getText().trim())));
    }


    public void switchNewTab() {
        Object[] windowHandles=Driver.getDriver().getWindowHandles().toArray();
        Driver.getDriver().switchTo().window((String) windowHandles[1]);

    }

    public void checkIfUrlCorrect(String expectedUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));

    }
    public void waitUntilElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickCookieAcceptButton(WebElement element) {
        element.click();
    }



}
