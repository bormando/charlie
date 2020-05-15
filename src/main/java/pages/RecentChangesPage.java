package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RecentChangesPage extends BasePage {
    public RecentChangesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement periodSelector() { return getElement(By.cssSelector(".mw-rcfilters-ui-changesLimitAndDateButtonWidget > span > a"), "Period selector"); }
    public WebElement period(String number) { return getElement(By.xpath(String.format("//div[contains(@class, 'mw-rcfilters-ui-changesLimitPopupWidget')]//span[.='%s']", number)), "Period"); }
    public List<WebElement> changes() { return getElements(By.cssSelector(".mw-changeslist-line-inner"), "Changes"); }

    public void open() {
        this.wd.get("https://en.wikipedia.org/wiki/Special:RecentChanges?hidebots=1&hidecategorization=1&hideWikibase=1&limit=50&days=7&urlversion=2");
    }

    public void selectPeriod(String number) {
        WebElement periodSelector = periodSelector();
        waitUntilClickable(periodSelector, "Period selector");
        periodSelector.click();
        WebElement period = period(number);
        waitUntilClickable(period, "Period");
        period.click();
    }

    public void checkNumberOfChangesShown(String number) {
        List<WebElement> changes = null;
        for (int i = 0; i < 15; i++) {
            changes = changes();
            if (changes.size() == Integer.parseInt(number)) { break; }
            else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        String changesFound = Integer.toString(changes.size());
        assert changesFound.equals(number) : String.format("Found changes %s, expected %s", changesFound, number);
    }
}
