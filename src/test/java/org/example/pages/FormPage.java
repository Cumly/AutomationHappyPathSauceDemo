package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.Duration;

public class FormPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElementFacade typeFirstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    private WebElementFacade typeLastName;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    private WebElementFacade typePostalCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElementFacade btnContinue;

    public void formComplete(String firstName, String lastName, String postalCode) throws InterruptedException {
        typeFirstName.withTimeoutOf(Duration.ofSeconds(100)).waitUntilEnabled();
        WebElementFacade tittleName = find(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        tittleName.waitUntilVisible().withTimeoutOf(Duration.ofSeconds(200));

        if (tittleName.isVisible()) {

            Thread.sleep(2000);
            typeFirstName.click();
            typeFirstName.type(firstName);

            typeLastName.click();
            typeLastName.type(lastName);

            typePostalCode.click();
            typePostalCode.type(postalCode);

            Thread.sleep(300);
            btnContinue.click();
        }
    }
}