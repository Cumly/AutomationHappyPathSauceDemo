package org.example.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class BrowserUtils extends PageObject {

    public void acceptAlert() {
        try {
            Thread.sleep(1000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            System.out.println("DEBUG: Error al intentar presionar ENTER: " + e.getMessage());
        }
    }

}