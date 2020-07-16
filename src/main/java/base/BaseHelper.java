package base;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class BaseHelper {
    private WebDriver driver;

    public BaseHelper(WebDriver driver) {this.driver = driver;}

    public void goLink(String link) {
        open(link);

    }

    public boolean checkDisplayedSiteWithProduct(String link) {
        return WebDriverRunner.url().contains(link);
    }

    public void waitForAjax(){
        try {
            for(;executeJavaScript("return jQuery.active == 0");) {
                Thread.sleep(150);
            }
            System.out.println("Ajax Call completed. ");
        } catch (InterruptedException e){
            System.out.println("Exception - " + e);
        }
    }
}
