import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    void validLoginTest() {
        HomePage homePage = new HomePage(webDriver, wait);
        homePage.goToLogin();

        LoginPage loginPage = new LoginPage(webDriver, wait);
        loginPage.login(webDriver, wait, "asddasdaasd@dasd.com", "1234qwe");

        String userText = homePage.getUserContainerText(webDriver, wait);
        Assert.assertEquals(userText, "Hesabım");
    }

    @Test
    void invalidLoginTest() {
        //go to login page
        ........ loginButton = webDriver.findElement(By.className("user-login-container"));
        loginButton.click();

        WebElement emailTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-email")));
        emailTextBox.sendKeys("asddasdaasd@dasd.com");

        WebElement passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-password-input")));
        passwordTextBox.sendKeys("1234qwe432651");

        LoginPage loginPage = new LoginPage(webDriver, wait);
        loginPage.click(locator_buttonSubmit);

        String errorBoxText = loginPage.getText(By.id("error-box-wrapper"));
        Assert.assertEquals(errorBoxText, "E-posta adresiniz ve/veya şifreniz hatalı.");

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=%2F");
    }

    ///1- Testing principles
    //2- Testing types
    //3- Testing pyramid
    //4- Selenium

}
