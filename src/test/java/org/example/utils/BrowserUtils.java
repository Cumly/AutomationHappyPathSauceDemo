package org.example.utils;

// ESTOS SON LOS IMPORTS QUE TE FALTAN:
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BrowserUtils {

    private WebDriver driver;

    // Constructor que recibe el driver desde el test
    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Espera y acepta alertas de JavaScript
     */
    public void acceptAlertIfPresent() {
        try {
            // Si WebDriver o WebDriverWait salen en rojo,
            // es que falta el import de arriba o la dependencia en el pom.xml
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println("DEBUG: Alerta encontrada: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("DEBUG: No se detectó ninguna alerta del navegador.");
        }
    }
}