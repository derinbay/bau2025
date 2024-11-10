import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToLogin() {
        click(By.className("user-login-container"));
    }

    public String getUserContainerText(WebDriver webDriver) {
        return getText(By.className("user-login-container"));
    }
}
