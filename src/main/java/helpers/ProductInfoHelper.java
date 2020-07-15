package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$;
import static locators.ProductInfoLocators.WHERE_TO_BUY_TAB;

public class ProductInfoHelper {

    public void openTabWhereToBuy() {
        WHERE_TO_BUY_TAB.click();
    }

    public ElementsCollection getLinkOfChipestOfferByCommentsAndWarranty(int comments, int warranty) {
        HashMap<String, String> comments1 = new HashMap<>();
        HashMap<String, String> warranty1 = new HashMap<>();
        HashMap<String, String> prices = new HashMap<>();

        ElementsCollection name = $$("[class='shop-box-in-title']");
        List<String> commentsLoc = $$("[class*='shop-box-in'] [data-tracking-id='offer-1']").texts();
        List<String> warrantyLoc = $$("[class='cell-2 cell-md m_b-sm']").texts();
        List<String> priceLoc = $$("[class='price-format'] [class=value]").texts();


        Stream<SelenideElement> collectionOfOffers =  $$("[class*='offers-item']").stream().forEach(el ->
        el.$("[class*='shop-box-in'] [data-tracking-id='offer-1']"));


        Stream<SelenideElement> collectionOfOffers =  $$("[class*='offers-item']").stream().filter(el ->
                Integer.parseInt(el.$("[class*='shop-box-in'] [data-tracking-id='offer-1']").text().substring(el.$("[class*='shop-box-in'] [data-tracking-id='offer-1']").text().indexOf(" "))) >= comments)
        .filter(el -> Integer.parseInt(el.$("[class='cell-2 cell-md m_b-sm']").text().trim()) >= warranty);
        collectionOfOffers.get(0).$("[class='btn-orange btn-cell']").click();
        return collectionOfOffers;
    }

}
