package base;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class BaseHelper {
    private WebDriver driver;

    public BaseHelper(WebDriver driver) {this.driver = driver;}

    public void goLink(String link) {
        open(link);
    }

    public boolean checkDisplayedSiteWithProduct(String link) {
        return WebDriverRunner.url().contains(link);
    }

    /**
     * Wait for Ajax call to finish
     */
    public void waitForReadyPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return jQuery.active == 0");
    }

}
