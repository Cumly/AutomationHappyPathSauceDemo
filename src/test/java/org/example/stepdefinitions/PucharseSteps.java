package org.example.stepdefinitions;

import com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.example.models.AuthData;
import org.example.models.User;
import org.example.pages.*;
import org.example.utils.BrowserUtils;
import org.example.utils.JsonUtils;
import org.junit.Assert;

import java.util.List;
import java.util.Random;

public class PucharseSteps {

    private float expectedSubtotal = 0.0f;

    List<User> users = JsonUtils.readJsonList(
            "src/test/resources/data/users.json",
            new TypeReference<List<User>>() {
            }
    );

    List<AuthData> credentials = JsonUtils.readJsonList(
            "src/test/resources/data/credentials.json",
            new TypeReference<List<AuthData>>() {
            }
    );

    @Steps
    BrowserUtils browserUtils;

    @Steps
    LoginPage loginPage;

    @Steps
    ProductPage productPage;

    @Steps
    FormPage formPage;

    @Steps
    CartPage cartPage;

    @Steps
    CheckPage checkPage;

    @Given("que el usuario esta en la página de inicio de sesión de Swag Labs")
    public void openLoginPage() {
        loginPage.openPage();
    }

    @When("Inicio sesión en el sistema con credenciales válidas")
    public void loginToSystem() {
        Random random = new Random();
        int randomIndex = random.nextInt(credentials.size());
        AuthData credential = credentials.get(randomIndex);
        loginPage.login(credential.getUsername(), credential.getPassword());
    }

    @When("Agrego los productos {string} y {string} al carrito")
    public void addProductsToCart(String product1, String product2) {
        expectedSubtotal = 0.0f;

        productPage.addProduct(product1);
        expectedSubtotal += productPage.getItemPrice(product1);

        productPage.addProduct(product2);
        expectedSubtotal += productPage.getItemPrice(product2);

    }

    @When("Visualizo los productos en el carrito para proceder con el pago")
    public void viewCart() throws InterruptedException {
        browserUtils.acceptAlert();
        cartPage.goToCart();
        if (!cartPage.isOnCartPage()) {
            throw new AssertionError("No se visualiza la página del carrito");
        }
        cartPage.clickBtnCheckout();

    }

    @When("Completo el formulario con los datos de envío")
    public void formCompleted() throws InterruptedException {
        if (users == null || users.isEmpty()) {
            throw new RuntimeException("ERROR: La lista de usuarios del JSON está vacía.");
        }

        Random random = new Random();
        int indexForUser = random.nextInt(users.size());
        User selectedUser = users.get(indexForUser);

        System.out.println("DEBUG: Llenando formulario con: " + selectedUser.getFirstName());

        formPage.formComplete(
                selectedUser.getFirstName(),
                selectedUser.getLastName(),
                selectedUser.getPostalCode()
        );
    }


    @Then("Valido que los productos {string} y {string} estén presentes en el resumen")
    public void verifyProductsArePresent(String product1, String product2) {
        boolean isP1Present = checkPage.isProductVisible(product1);
        Assert.assertTrue("El producto '" + product1 + "' no se encontró en el resumen", isP1Present);

        boolean isP2Present = checkPage.isProductVisible(product2);
        Assert.assertTrue("El producto '" + product2 + "' no se encontró en el resumen", isP2Present);

    }

    @Then("Verifico que el subtotal sea la suma de ambos productos")
    public void verifySubtotalAmount() {
        float actualSubtotal = checkPage.getSubtotal();
        Assert.assertEquals("La suma calculada no coincide con el subtotal de la página",
                expectedSubtotal, actualSubtotal, 0.01);

    }


    @Then("Finalizo la compra exitosamente visualizando el mensaje de confirmación")
    public void finishPurchase() {

        if (!checkPage.isOnCheckPage()) {
            throw new AssertionError("No se visualiza la información de venta");
        }
        checkPage.finishPucharse();
        if (!checkPage.isCheckoutComplete()) {
            throw new AssertionError("No se visualiza ");
        }
    }



}
