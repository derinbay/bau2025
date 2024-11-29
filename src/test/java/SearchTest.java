import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class SearchTest extends BaseTest {

    @Test
    void testSearchWithButton() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.searchWithoutEnter(Consts.KEYWORD);

        String resultText = searchResultPage.fetchSearchResultText();
        Assert.assertEquals(resultText, Consts.KEYWORD);
    }

    @Test
    void testSearchWithEnter() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.searchWithEnter(Consts.KEYWORD + ENTER);

        String resultText = searchResultPage.fetchSearchResultText();
        Assert.assertEquals(resultText, Consts.KEYWORD);
    }
}
