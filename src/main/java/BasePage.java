import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    By locator_searchBox = By.xpath("//input[@data-testid='suggestion']");

    void click(By by) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    String getText(By by) {
        return findElement(by)
                .getText();
    }

    WebElement findElement(By by) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    void sendKeys(By by, String textToEnter) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(3));
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

    public String getCurrentUrl() {
        return BaseTest.getDriver().getCurrentUrl();
    }

    public SearchResultPage searchWithEnter(String keyword) {
        sendKeys(locator_searchBox, keyword);
        return new SearchResultPage();
    }

    public SearchResultPage searchWithoutEnter(String keyword) {
        sendKeys(locator_searchBox, keyword);
        click(By.xpath("//i[@data-testid='search-icon']"));
        return new SearchResultPage();
    }
}
