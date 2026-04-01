package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;


public class LoginPage extends PageObject {

    @FindBy(xpath  = "//*[@id=\"user-name\"]")
    private WebElementFacade userName;

    @FindBy(xpath  = "//*[@id=\"password\"]")
    private WebElementFacade Password;

    @FindBy (xpath  = "//*[@id=\"login-button\"]")
    private WebElementFacade btnLogin;

    public void login(String username, String password) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(userName))).sendKeys(username);
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(Password))).sendKeys(password);
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(btnLogin))).click();
    }

    public void openPage() {
        openUrl("https://www.saucedemo.com");
    }

}
