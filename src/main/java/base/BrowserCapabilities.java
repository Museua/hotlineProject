package base;

import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static base.ConfigData.getCfgValue;
public class BrowserCapabilities {
    RemoteWebDriver driver;
    private String browser = PropertiesManager.getInstance().getResourceByName("browser").contains("$") ?
            getCfgValue("BROWSER") :
            PropertiesManager.getInstance().getResourceByName("browser");

    public BrowserCapabilities() {}

    public WebDriver initBrowserCapabilities() {
        switch (browser) {
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                driver = new FirefoxDriver();
                WebDriverRunner.setWebDriver(driver);
                break;
           case ("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                WebDriverRunner.setWebDriver(driver);
                break;
        }

        return driver;
    }
}
