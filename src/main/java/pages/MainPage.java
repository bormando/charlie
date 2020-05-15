package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        this.wd.get("https://en.wikipedia.org/wiki/Main_Page");
    }
}
