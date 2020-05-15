package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement username() { return getElement(By.cssSelector("#wpName1"), "Username input field"); }
    public WebElement password() {
        return getElement(By.id("wpPassword1"), "Password input field");
    }
    public WebElement logInBtn() {
        return getElement(By.name("wploginattempt"), "'Log in' button");
    }
    public WebElement error() {
        return getElement(By.cssSelector(".errorbox"), "Error message");
    }

    public void open() {
        this.wd.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
    }

    public void enterUsername(String usernameParameter) {
        username().sendKeys(usernameParameter);
    }

    public void enterPassword(String passwordParameter) {
        password().sendKeys(passwordParameter);
    }

    public void logIn() {
        waitUntilClickable(logInBtn(), "'Log in' button");
        logInBtn().click();
    }

    public void wrongUsernameOrPasswordError() {
        String errorText = error().getText();
        assert errorText.contains("Incorrect username or password") :
                String.format("Error message is something different: '%s'", errorText);
    }
}
