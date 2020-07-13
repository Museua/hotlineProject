package base;

import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;

public class BaseHelper {
    private WebDriver driver;

    public BaseHelper(WebDriver driver) {this.driver = driver;}

    public void goLink(String link) {
        open(link);
    }
}
