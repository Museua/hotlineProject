package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

public class E2eTests  extends TestBase {

    @BeforeMethod
    public void initializeVariables(){
        softAssert = new SoftAssert();
    }

    @Test
    public void useCase1(){
        log.info("Test is started");
        goLink("https://hotline.ua");
        log.info("Search needed product");
        pagesInit.getMainPage().searchProduct("iPhone");
        log.info("Open suitable product");
        pagesInit.getSearchResultPage().openFirstSuitableResultByText("Apple iPhone 7");
        log.info("Open tab with offers");
        pagesInit.getProductInfoPage().openTabWhereToBuy();
        log.info("Get cheaper offer and go to offer page");
        pagesInit.getProductInfoPage().getLinkOfChipestOfferByCommentsAndWarranty(10, 6);
        log.info("Check is open offer page");
        Assert.assertTrue(pagesInit.getBaseHelper().checkDisplayedSiteWithProduct("bigmag.ua"));
        log.info("Test is finished");
    }

    @Test
    public void useCase2(){
        log.info("Test is started");
        goLink("https://hotline.ua");
        log.info("Search needed product");
        pagesInit.getMainPage().searchProduct("iPhone");
        log.info("Sort products");
        pagesInit.getSearchResultPage().sortOffersBy("к-ву предложений");
        log.info("Check matching page list with file list");
        Assert.assertTrue(pagesInit.getSearchResultPage().checkMatchingDisplayedProductsWithProvided(10,"src/main/resources/files/listOfProducts.csv"));
        log.info("Test is finished");
    }
}
