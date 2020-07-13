package pages;

import helpers.MainPageHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static locators.MainPageLocators.SEARCH_INPUT;

public class MainPage {
    private WebDriver driver;
    private MainPageHelper mainPageHelper;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        mainPageHelper = new MainPageHelper();
    }

    public void searchProduct(String text) {
        mainPageHelper.searchProduct(text);
    }
}
