package base;

import org.testng.log4testng.Logger;
import pages.MainPage;
import pages.ProductInfoPage;
import pages.SearchResultPage;

public class PagesInit {

    private BrowserCapabilities browserCapabilities;
    private Driver driver;
    private Logger log;

    MainPage mainPage;
    SearchResultPage searchResultPage;
    BaseHelper baseHelper;
    ProductInfoPage productInfoPage;

    public PagesInit() {
        driver = new Driver();
        log = Logger.getLogger(getClass());
        browserCapabilities = new BrowserCapabilities();
    }

    public Driver getDriver() {
        return driver;
    }

    public void init() {
        try {
            //browser driver initialization
            driver.setDriver(browserCapabilities.initBrowserCapabilities());

            //pages
            mainPage = new MainPage(driver.getDriver());
            searchResultPage = new SearchResultPage(driver.getDriver(), log);
            baseHelper = new BaseHelper(driver.getDriver());
            productInfoPage = new ProductInfoPage(driver.getDriver());

        } catch (Exception e) {
            System.out.println("Catch " + e);
        }
    }

    public MainPage getMainPage() {
        return mainPage;
    }
    public SearchResultPage getSearchResultPage() { return searchResultPage; }
    public BaseHelper getBaseHelper() { return baseHelper; }
    public ProductInfoPage getProductInfoPage() { return productInfoPage; }
}
