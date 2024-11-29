import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {

    By locator_resultText = By.xpath("//div[@class='dscrptn dscrptn-V2']/h1");

    public String fetchSearchResultText() {
        return getText(locator_resultText);
    }

//    public void getFirstProduct() {
//        WebElement rushDeliveryElement = findElement(By.cssSelector(".p-card-wrppr .rushDelivery"));
//        WebElement rushDeliveryElement = findElement(By.xpath("//div[@class='p-card-wrppr with-campaign-view']//div[@class='product-stamp-container rushDelivery']"));
//        WebElement rushDeliveryElement = findElement(By.xpath("//div[@class='p-card-wrppr with-campaign-view']//div[@class='product-stamp-container rushDelivery']"));
//        WebElement rushDeliveryElement = findElement(By.xpath("//div[contains(@class,'p-card-wrp')]//div[@class='product-stamp-container rushDelivery']"));
//        System.out.println("dasd");
//    }
}
