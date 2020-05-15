package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSuite {
    protected RemoteWebDriver driver;
    @BeforeTest
    @Parameters({ "browserAddress", "browserName", "implicitlyWait" })
    public void startDriver(String browserAddress, String browserName, Integer implicitlyWait) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browserName);
        this.driver = new RemoteWebDriver(new URL(browserAddress), caps);
        this.driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    }

    @AfterTest
    public void shutDownDriver() {
        driver.quit();
    }
}
