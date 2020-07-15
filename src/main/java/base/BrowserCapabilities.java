package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

public class BrowserCapabilities {
    WebDriver driver;
    private String browser = "chrome";

    public BrowserCapabilities() {}

    public void initBrowserCapabilities() {
        switch (browser) {
            case ("firefox"):
//                FirefoxOptions firefoxOptions = new FirefoxOptions().setLogLevel(FirefoxDriverLogLevel.ERROR);
//                firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
//                WebDriverManager.firefoxdriver().setup();
//                Configuration.browser = "firefox";
//                System.setProperty("firefoxprofile.dom.webnotifications.serviceworker.enabled", "false");
//                System.setProperty("firefoxprofile.dom.webnotifications.enabled", "false");
//                System.setProperty("firefoxprofile.geo.enabled", "false");
//
//                System.setProperty("webdriver.firefox.bin", "path to the custom profile for firefox browser");
//                ProfilesIni profilesIni = new ProfilesIni();
//                FirefoxProfile firefoxProfile = profilesIni.getProfile("default");
//                driver = new FirefoxDriver(firefoxProfile);
//                WebDriverRunner.setWebDriver(driver);
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                WebDriverRunner.setWebDriver(driver);
           case ("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                WebDriverRunner.setWebDriver(driver);

//                WebDriverManager.chromedriver().setup();
//                Configuration.browser = "chrome";
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("–disable-notifications");
        }

//        driver.getDriver().manage().window().setSize(new Dimension(1200, 800));
//        WebDriverRunner.setWebDriver(driver.getDriver());
    }
}
