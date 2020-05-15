package tests;

import config.TestSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ArticlePage;;
import pages.MainPage;

public class SearchTests extends TestSuite {
    @Test
    @Parameters({ "searchValue", "expectedValue" })
    public void searchForSpecificResult(String searchValue, String expectedValue) {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.open();
        mainPage.searchFor(searchValue);
        ArticlePage articlePage = new ArticlePage(this.driver);
        articlePage.checkArticleName(expectedValue);
    }
}
