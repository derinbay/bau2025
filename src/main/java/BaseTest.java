import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class BaseTest {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    By locator_buttonSubmit = By.className("submit");

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    @BeforeMethod
    void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        if (isRemote()) {
            try {
                webDriver.set(new RemoteWebDriver(new URL("http://10.0.18.248:4444"), options));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            webDriver.set(new ChromeDriver(options));
        }

        getDriver().get("https://www.trendyol.com/");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.of(3, SECONDS));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        acceptButton.click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.className("homepage-popup-gender")))
        //        .click();
    }

    @AfterMethod
    void tearDown() {
        getDriver().quit();
    }

    public static boolean isRemote() {
        return java.util.Optional.ofNullable(System.getProperties().getProperty("remote"))
                .map(Boolean::parseBoolean)
                .orElse(false);
    }
}
