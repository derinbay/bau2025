import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void login(WebDriver webDriver, String email, String password) {
        WebElement emailTextBox = webDriver.findElement(By.id("login-email"));
        emailTextBox.sendKeys(email);
        WebElement passwordTextBox = webDriver.findElement(By.id("login-password-input"));
        passwordTextBox.sendKeys(password);

        WebElement submitButton = webDriver.findElement(By.className("submit"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/butik/liste/1/kadin"));
    }
}