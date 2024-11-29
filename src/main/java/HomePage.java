import org.openqa.selenium.By;

public class HomePage extends BasePage {

    By locator_loginContainer = By.className("user-login-container");

    public HomePage() {}

    public LoginPage goToLogin() {
        click(locator_loginContainer);
        return new LoginPage();
    }

    public String getUserContainerText() {
        return getText(locator_loginContainer);
    }
}
