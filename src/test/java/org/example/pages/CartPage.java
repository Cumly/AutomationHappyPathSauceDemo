package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.time.Duration;

public class CartPage extends PageObject {

    public void goToCart() {
        evaluateJavascript("document.querySelector('.shopping_cart_link').click();");
    }

    public boolean isOnCartPage() {
        return find(By.id("checkout")).withTimeoutOf(Duration.ofSeconds(10)).isVisible();
    }

    public void clickBtnCheckout() throws InterruptedException {
        WebElementFacade checkoutReal = find(By.id("checkout"));
        checkoutReal.withTimeoutOf(Duration.ofSeconds(200)).waitUntilVisible();
        Thread.sleep(3000);
        evaluateJavascript("document.getElementById('checkout').click();");
    }
}