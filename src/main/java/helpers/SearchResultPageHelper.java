package helpers;

import org.testng.log4testng.Logger;

import static com.codeborne.selenide.Selenide.$$;
import static locators.SearchResultLocators.LIST_OF_SUITABLE_PRODUCTS;

public class SearchResultPageHelper {
    private Logger log;

    public SearchResultPageHelper(Logger log){this.log = log;}

    public void openFirstSuitableResultByText(String nameOfProduct) {
        if ($$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).size() > 0) {
            $$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).get(0).click();
        } else {
            log.info("There are no suitable products. Size of list - " + $$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).size());
        }
    }
}
