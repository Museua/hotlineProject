package locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultLocators {
    public static String LIST_OF_SUITABLE_PRODUCTS = "[class='h4'] [title*='%s']";
    public static ElementsCollection PRODUCT_TITLES = $$("[class=h4] [title]");
    public static SelenideElement SORT_SELECT = $("[name='sort']");
}
