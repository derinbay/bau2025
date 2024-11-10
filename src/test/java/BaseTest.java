import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class BaseTest {

    WebDriver webDriver;
    By locator_buttonSubmit = By.className("submit");

    @BeforeMethod
    void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.trendyol.com/");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.of(3, SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("homepage-popup-gender")))
                .click();
        //        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        //        acceptButton.click();
    }

    @AfterMethod
    void tearDown() {
        webDriver.quit();
    }
}
