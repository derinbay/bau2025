import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver webDriver;
    WebDriverWait wait;

    void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    void click(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    String getText(By by) {
        return findElement(by)
                .getText();
    }

    WebElement findElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    void sendKeys(By by, String textToEnter) {
        wait.until(ExpectedConditions.elementToBeClickable(by))
                .sendKeys(textToEnter);
    }

    public boolean isElementExist(WebDriver webDriver, By by) {
        try {
            return webDriver.findElement(by)
                    .isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException ex) {
            return false;
        }
    }
}
