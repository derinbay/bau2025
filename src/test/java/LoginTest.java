import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    void validLoginTest() {
        HomePage homePage = new HomePage(webDriver);
        homePage.goToLogin();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(webDriver, "asddasdaasd@dasd.com", "1234qwe");

        String userText = homePage.getUserContainerText(webDriver);
        Assert.assertEquals(userText, "Hesabım");
    }

    @Test
    void invalidLoginTest() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        //go to login page
        WebElement loginButton = webDriver.findElement(By.className("user-login-container"));
        loginButton.click();

        WebElement emailTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-email")));
        emailTextBox.sendKeys("asddasdaasd@dasd.com");

        WebElement passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-password-input")));
        passwordTextBox.sendKeys("1234qwe432651");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.click(locator_buttonSubmit);

        String errorBoxText = loginPage.getText(By.id("error-box-wrapper"));
        Assert.assertEquals(errorBoxText, "E-posta adresiniz ve/veya şifreniz hatalı.");

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=%2Fbutik%2Fliste%2F1%2Fkadin");
    }

    // Midterm:
    //1- Testing principles
    //2- Testing types
    //3- Testing pyramid
    //4- Selenium

}
