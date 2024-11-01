import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    void validLoginTest() {
        //go to login page
        WebElement loginButton = webDriver.findElement(By.className("user-login-container"));
        loginButton.click();

        //enter valid username
        WebElement emailTextBox = webDriver.findElement(By.id("login-email"));
        emailTextBox.sendKeys("asddasdaasd@dasd.com");

        WebElement passwordTextBox = webDriver.findElement(By.id("login-password-input"));
        passwordTextBox.sendKeys("1234qwe");

        WebElement submitButton = webDriver.findElement(By.className("submit"));
        submitButton.click();

        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/"));

        WebElement isim = webDriver.findElement(By.className("user-login-container"));
        Assert.assertEquals(isim.getText(), "Hesabım");
    }

    @Test
    void invalidLoginTest() {
        //go to login page
        WebElement loginButton = webDriver.findElement(By.className("user-login-container"));
        loginButton.click();

        WebElement emailTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-email")));
        emailTextBox.sendKeys("asddasdaasd@dasd.com");

        WebElement passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-password-input")));
        passwordTextBox.sendKeys("1234qwe432651");

        click(locator_buttonSubmit);

        String errorBoxText = getText(By.id("error-box-wrapper"));
        Assert.assertEquals(errorBoxText, "E-posta adresiniz ve/veya şifreniz hatalı.");

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=%2F");
    }
}
