package helpers;

import base.BaseHelper;
import com.codeborne.selenide.*;
import org.openqa.selenium.WebDriver;

import java.util.*;
import static com.codeborne.selenide.Selenide.*;
import static locators.ProductInfoLocators.*;

public class ProductInfoHelper {
    WebDriver driver;

    public ProductInfoHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openTabWhereToBuy() {
        WHERE_TO_BUY_TAB.scrollIntoView("{block: \"center\"}").click();
    }

    public String getChipestPriceWithFittedOptionsCommentsAndWarranty(int commentsAmount, int warrantyAmount) {
        List<Integer> fittedPrices = new ArrayList<>();
        ElementsCollection offerId = OFFERS.shouldBe(CollectionCondition.sizeGreaterThan(0));
        for(SelenideElement elem:offerId) {
            if ($("[data-id='" + elem.getAttribute("data-id") + "'] [data-tracking-id='offer-1']").isDisplayed()) {
                String rareCommentText = $("[data-id='" + elem.getAttribute("data-id") + "'] [data-tracking-id='offer-1']").text();
                Integer commAmount = Integer.parseInt(rareCommentText.substring(0, rareCommentText.indexOf(" ")));
                if (commAmount > commentsAmount) {
                    try {
                        String rareWarrText = $("[data-id='" + elem.getAttribute("data-id") + "'] [class='cell-2 cell-md m_b-sm']").text();
                        Integer warrAmount = Integer.parseInt(rareWarrText.substring(0, rareWarrText.indexOf(" ")));
                        if (warrAmount > warrantyAmount) {
                            String rarePriceText = $("[data-id='" + elem.getAttribute("data-id") + "'] [class='price-format'] [class='value']").text().replace(" ", "");
                            Integer cost = Integer.parseInt(rarePriceText);
                            fittedPrices.add(cost);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        Collections.sort(fittedPrices);

        return fittedPrices.get(0).toString();
    }

    public void openLinkWithChiepestPrice(String price) {
        $x("//span[@class='price-format']//span[contains(., '" + price.substring(0, price.length() - 3) + "') and contains(., '" + price.substring(price.length() - 3) + "')]").click();
        switchTo().window(1);
    }
}
