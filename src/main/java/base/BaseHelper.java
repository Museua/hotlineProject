package base;

import com.codeborne.selenide.Condition;
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
        $x("//*[contains(.,'iPhone')]").shouldBe(Condition.visible);
        return WebDriverRunner.url().contains(link);
    }
}
