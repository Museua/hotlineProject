package pages;

import helpers.SearchResultPageHelper;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;


public class SearchResultPage {
    private WebDriver driver;
    private SearchResultPageHelper searchResultPageHelper;
    private Logger log;

    public SearchResultPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        searchResultPageHelper = new SearchResultPageHelper(log);
    }

    public void openFirstSuitableResultByText(String nameOfProduct) {
        searchResultPageHelper.openFirstSuitableResultByText(nameOfProduct);
    }

    public boolean checkMatchingDisplayedProductsWithProvided(String pathToFile) {
        return searchResultPageHelper.checkMatchingDisplayedProductsWithProvided(pathToFile);
    }

    public void sortOffersBy(String text) {
        searchResultPageHelper.sortOffersBy(text);
    }
}
