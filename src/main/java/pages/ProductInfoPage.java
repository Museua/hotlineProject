package pages;

import helpers.ProductInfoHelper;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage {
    private WebDriver driver;
    private ProductInfoHelper productInfoHelper;

    public ProductInfoPage(WebDriver driver) {this.driver = driver;
        productInfoHelper = new ProductInfoHelper(driver);}

    public void openTabWhereToBuy() {
        productInfoHelper.openTabWhereToBuy();
    }

    public void getLinkOfChipestOfferByCommentsAndWarranty(int comments, int warranty) {
        String chipestPrice = productInfoHelper.getChipestPriceWithFittedOptionsCommentsAndWarranty(comments, warranty);
        productInfoHelper.openLinkWithChiepestPrice(chipestPrice);
    }
}
