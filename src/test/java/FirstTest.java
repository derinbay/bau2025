import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    private static final Logger log = LoggerFactory.getLogger(FirstTest.class);

    //1- valid user name and password
    //	- enter valid username
    //	- enter valid password
    //	- click giriş yap button
    //	- assert to see hesabım instead of giriş yap
    //	- assert redirect to homepage

    @Test
    void firstTest() {
        //open a chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver webDriver = new ChromeDriver(options);

        //go to trendyol.com
        webDriver.get("https://www.trendyol.com/");

        // notificaiton allow disable


        // sana özel deneyim kabul et
        WebElement acceptButton = webDriver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptButton.click();

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

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.trendyol.com/");

        WebElement isim = webDriver.findElement(By.className("user-login-container"));
        Assert.assertEquals(isim.getText(), "Hesabım");
        }
}
