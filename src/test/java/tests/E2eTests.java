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
        goLink("wages/clients");
        pagesInit.getMainPage().searchProduct("iPhone");
        pagesInit.getSearchResultPage().openFirstSuitableResultByText("Apple iPhone 7");
        pagesInit.getProductInfoPage().openTabWhereToBuy();
        pagesInit.getProductInfoPage().getLinkOfChipestOfferByCommentsAndWarranty(10, 6);
        Assert.assertTrue(pagesInit.getBaseHelper().checkDisplayedSiteWithProduct());
        log.info("Test is finished");
    }

}
