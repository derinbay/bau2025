import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage() {}

    public LoginPage goToLogin() {
        click(By.className("user-login-container"));
        return new LoginPage();
    }

    public String getUserContainerText() {
        return getText(By.className("user-login-container"));
    }
}
