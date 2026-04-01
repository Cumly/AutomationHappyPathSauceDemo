package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"add-to-cart\"]")
    private WebElementFacade btnAdd;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private WebElementFacade btnBack;

    @FindBy(className = "inventory_details_price")
    private WebElementFacade priceText;

    public void addProduct(String productName) {
        String idSuffix = productName.toLowerCase().trim().replace(" ", "-");
        String buttonId = "add-to-cart-" + idSuffix;

        evaluateJavascript("document.getElementById('" + buttonId + "').click();");


    }

    public float getItemPrice(String productName) {
        String xpathPrice = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']";

        String priceRaw = $(By.xpath(xpathPrice))
                .waitUntilVisible()
                .getText();
        return Float.parseFloat(priceRaw.replace("$", "").trim());
    }



}
