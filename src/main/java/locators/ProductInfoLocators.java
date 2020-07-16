package locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductInfoLocators {
    public static SelenideElement WHERE_TO_BUY_TAB = $("[title*='Где купить']");
    public static SelenideElement DIALOG_POPUP_BLOCK_BUTTON = $("[class='sub-dialog-btn block_btn']");
}
