import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class SearchTest extends BaseTest {

    @Test
    void testSearch() {
        HomePage homePage = new HomePage(webDriver, wait);
        homePage.sendKeys(By.xpath("//input[@data-testid='suggestion']"), Consts.KEYWORD + ENTER);
        String text = homePage.getText(By.xpath("//div[@class='dscrptn dscrptn-V2']/h1"));
        Assert.assertEquals(text, Consts.KEYWORD);

        /**
         * page object model
         * */
    }
}
