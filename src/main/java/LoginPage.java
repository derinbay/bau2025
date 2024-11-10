import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void login(WebDriver webDriver, WebDriverWait wait, String email, String password) {
        WebElement emailTextBox = webDriver.findElement(By.id("login-email"));
        emailTextBox.sendKeys(email);
        WebElement passwordTextBox = webDriver.findElement(By.id("login-password-input"));
        passwordTextBox.sendKeys(password);

        WebElement submitButton = webDriver.findElement(By.className("submit"));
        submitButton.click();

        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/"));
    }
}