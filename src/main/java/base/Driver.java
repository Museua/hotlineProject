package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
    private WebDriver driver;

    public Driver(){
    }

    public WebDriver getDriver() {
        return driver;
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
}
