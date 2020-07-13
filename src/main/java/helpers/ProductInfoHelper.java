package helpers;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static locators.ProductInfoLocators.WHERE_TO_BUY_TAB;

public class ProductInfoHelper {

    public void openTabWhereToBuy() {
        WHERE_TO_BUY_TAB.click();
    }

    public void getLinkOfChipestOfferByCommentsAndWarranty(int comments, int warranty) {
        ElementsCollection collectionOfOffers = (ElementsCollection) $$("[class*='offers-item']").stream().filter(el ->
                Integer.parseInt(el.$("[class*='shop-box-in'] [data-tracking-id='offer-1']").text().substring(el.$("[class*='shop-box-in'] [data-tracking-id='offer-1']").text().indexOf(" "))) >= comments)
        .filter(el -> Integer.parseInt(el.$("[class='cell-2 cell-md m_b-sm']").text().trim()) >= warranty);
        collectionOfOffers.get(0).$("[class='btn-orange btn-cell']").click();
    };

}
