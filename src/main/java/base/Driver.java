package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {
    private WebDriver driver;

    public Driver(){
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void close() {
        if (!(hasLive() || hasQuit())) {
            driver.close();
        }
    }

    public void stop() {
        try {
            driver.quit();
            driver = null;
        } catch (Exception e) {
            System.out.println("Catch stop - " + e);
        }
    }

    public boolean hasQuit() {
        return ((RemoteWebDriver) driver).getSessionId() == null;
    }

    public boolean hasLive() {
        return driver == null;
    }

    public Object setDriver(URL url, ChromeOptions options) {
        this.driver = new RemoteWebDriver(url, options);
        return this.driver;
    }
}
