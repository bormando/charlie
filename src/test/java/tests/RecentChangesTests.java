package tests;

import config.TestSuite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RecentChangesPage;

public class RecentChangesTests extends TestSuite {
    @DataProvider
    public Object[][] getNumber(ITestContext context) {
        String parameter = context.getCurrentXmlTest().getLocalParameters().get("numbers");
        String[] numbers = parameter.split(", ");
        Object[][] returnValues = new Object[numbers.length][1];
        int index = 0;
        for (Object[] each : returnValues) {
            each[0] = numbers[index++].trim();
        }
        return returnValues;
    }

    @Test(dataProvider = "getNumber")
    public void showSelectedNumberOfChanges(String number) {
        RecentChangesPage recentChangesPage = new RecentChangesPage(this.driver);
        recentChangesPage.open();
        recentChangesPage.selectPeriod(number);
        recentChangesPage.checkNumberOfChangesShown(number);
    }
}
