import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void goToLogin() {
        click(By.className("user-login-container"));
    }

    public String getUserContainerText(WebDriver webDriver, WebDriverWait wait) {
        return getText(By.className("user-login-container"));
    }
}
