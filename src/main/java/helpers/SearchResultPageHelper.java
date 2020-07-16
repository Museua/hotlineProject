package helpers;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.testng.log4testng.Logger;

import static com.codeborne.selenide.Selenide.*;
import static locators.SearchResultLocators.LIST_OF_SUITABLE_PRODUCTS;

public class SearchResultPageHelper {
    private Logger log;

    public SearchResultPageHelper(Logger log){this.log = log;}

    public void openFirstSuitableResultByText(String nameOfProduct) {
        $(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).shouldBe(Condition.visible);
        if ($$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).size() > 0) {
            $$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).get(0).click();
            System.out.println($$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).size());
        } else {
            log.info("There are no suitable products. Size of list - " + $$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).size());
        }
    }
}
