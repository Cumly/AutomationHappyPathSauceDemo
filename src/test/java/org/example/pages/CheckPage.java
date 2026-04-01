package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;

public class CheckPage extends PageObject {

    @FindBy(id = "finish")
    private WebElementFacade btnFinish;

    @FindBy(className = "title")
    private WebElementFacade lblTitleSummary;

    @FindBy(className = "summary_subtotal_label")
    private WebElementFacade lblPrice;

    @FindBy(className = "complete-header")
    private WebElementFacade lblThanks;

    public float getSubtotal() {
        String priceText = lblPrice.waitUntilVisible().getText();
        String cleanPrice = priceText.replaceAll("[^0-9.]", "");
        return Float.parseFloat(cleanPrice);
    }

    public boolean isProductVisible(String productName) {
        waitABit(1000);
        List<WebElementFacade> listaProductos = findAll(By.className("inventory_item_name"));

        for (WebElementFacade element : listaProductos) {
            if (element.getText().trim().equalsIgnoreCase(productName.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean isCheckoutComplete() {
        return lblThanks.waitUntilVisible().getText().contains("Thank you for your order!");
    }

    public void finishPucharse() {
        btnFinish.waitUntilClickable().click();
    }

    public boolean isOnCheckPage() {
        return lblTitleSummary.withTimeoutOf(Duration.ofSeconds(5)).isVisible();
    }
}