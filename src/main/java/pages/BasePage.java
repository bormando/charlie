package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

abstract class BasePage {
    public WebDriver wd;

    public BasePage(WebDriver webDriver) {
        this.wd = webDriver;
    }

    public WebElement getElement(By selector, String name) {
        WebElement element = null;
        try {
             element = this.wd.findElement(selector);
        }
        catch (NoSuchElementException e) {
            assert false : String.format("%s not found", name);
        }
        return element;
    }

    public WebElement getElementFlaky(By selector) {
        try {
            return this.wd.findElement(selector);
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<WebElement> getElements(By selector, String name) {
        List<WebElement> elements = null;
        try {
            elements = this.wd.findElements(selector);
        }
        catch (NoSuchElementException e) {
            assert false : String.format("%s not found", name);
        }
        return elements;
    }

    public void waitUntilClickable(WebElement element, String name) {
        try {
            WebDriverWait wait = new WebDriverWait(this.wd, 15);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (TimeoutException e) {
            assert false : String.format("%s not found", name);
        }
    }

    public WebElement searchInput() { return getElement(By.cssSelector("#searchInput"), "Search input field"); }
    public WebElement searchSuggestionsFlaky() { return getElementFlaky(By.cssSelector("div.suggestions")); }

    public void searchFor(String value) {
        searchInput().sendKeys(value);
        searchSuggestionsFlaky();
        searchInput().sendKeys(Keys.ENTER);
    }
}
