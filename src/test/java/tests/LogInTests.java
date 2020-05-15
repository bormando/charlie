package tests;

import config.TestSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTests extends TestSuite {
    @Test
    @Parameters({ "username", "password" })
    public void logInWithWrongCredentials(String usernameParameter, String passwordParameter) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.open();
        logInPage.enterUsername(usernameParameter);
        logInPage.enterPassword(passwordParameter);
        logInPage.logIn();
        logInPage.wrongUsernameOrPasswordError();
    }
}
