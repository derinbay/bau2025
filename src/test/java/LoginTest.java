import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    void validLoginTest() {
        User user = UserPool.validUser();

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLogin();
        homePage = loginPage.successLogin(user);
        String userText = homePage.getUserContainerText();

        assertEquals(userText, Consts.MY_ACCOUNT);
    }

    @Test
    void invalidLoginTest() {
        User user = UserPool.invalidUser();

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLogin();
        loginPage.login(user);

        String errorBoxText = loginPage.getErrorMessage();
        assertEquals(errorBoxText, Consts.LOGIN_ERROR_TEXT);

        String currentUrl = loginPage.getCurrentUrl();
        assertEquals(currentUrl, Consts.EXPECTED_LOGIN_REDIRECTION_URL);
    }
}
