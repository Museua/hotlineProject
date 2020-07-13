package helpers;

import org.openqa.selenium.Keys;

import static locators.MainPageLocators.SEARCH_INPUT;

public class MainPageHelper {

    public void searchProduct(String text) {
        SEARCH_INPUT.sendKeys(text + Keys.ENTER);
    }
}
