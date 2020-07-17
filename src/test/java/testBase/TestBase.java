package testBase;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import base.PagesInit;

import java.util.logging.Logger;

import static libs.Listeners.listenersForSelenide;

public class TestBase {

    public SoftAssert softAssert;
    protected PagesInit pagesInit;
    protected Logger log;

    public TestBase() {
        softAssert = new SoftAssert();
        pagesInit = new PagesInit();
        log = Logger.getLogger(String.valueOf(getClass()));
    }

    @BeforeClass
    public void classInit(ITestContext context) {
        try {
            runInit();
            listenersForSelenide();
            }
        catch (Exception e){
            System.out.println("Catch " + e);
        }
    }

    @AfterMethod
    public void driverDieBeforeMethod(ITestResult result){
        try{
            WebDriverRunner.closeWebDriver();
        }
        catch (Exception e){
            System.out.println("Catch driverDieBeforeMethod " + e);
        }
    }

    private void runInit() {
        try {
            if(pagesInit.getDriver().hasLive() || pagesInit.getDriver().hasQuit()){
                pagesInit.init();
            }
        } catch (Exception e) {
            System.out.println("Catch " + e);
        }
    }

    /**
     * go to link
     */
    public void goLink(String link) {
        pagesInit.getBaseHelper().goLink(link);
    }
}
