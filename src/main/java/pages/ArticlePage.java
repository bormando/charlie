package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {
    public ArticlePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement articleName() { return getElement(By.cssSelector(".firstHeading"), "Article name"); }

    public void checkArticleName(String name) {
        String articleNameText = articleName().getText();
        assert articleNameText.equals(name) : String.format("Article name is something different: %s", articleNameText);
    }
}
