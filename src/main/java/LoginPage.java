import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage() {}

    public HomePage successLogin(User user) {
        login(user);

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/"));

        return new HomePage();
    }

    public void login(User user) {
        sendKeys(By.id("login-email"), user.getEmail());
        sendKeys(By.id("login-password-input"), user.getPassword());
        click(By.className("submit"));
    }

    public String getErrorMessage() {
        return getText(By.id("error-box-wrapper"));
    }
}