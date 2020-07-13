package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserCapabilities {
    private FirefoxProfile profile;
    private String browser = "";

    public BrowserCapabilities() {}

    public void initBrowserCapabilities(WebDriver driver) {
        switch (browser) {
            case ("firefox"):
                FirefoxOptions firefoxOptions = new FirefoxOptions().setLogLevel(FirefoxDriverLogLevel.ERROR);
                firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
                WebDriverManager.firefoxdriver().setup();
                Configuration.browser = "firefox";
                System.setProperty("firefoxprofile.dom.webnotifications.serviceworker.enabled", "false");
                System.setProperty("firefoxprofile.dom.webnotifications.enabled", "false");
                System.setProperty("firefoxprofile.geo.enabled", "false");

            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
                ChromeOptions options = new ChromeOptions();
                options.addArguments("–disable-notifications");
        }

        driver.manage().window().setSize(new Dimension(1200, 800));
        WebDriverRunner.setWebDriver(driver);
    }
}
