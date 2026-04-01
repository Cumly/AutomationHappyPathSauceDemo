package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverHooks {

    @Before(order = 0)
    public void setupDriver() {
        WebDriverManager.edgedriver().setup();
    }

    @After(order = 0)
    public void closeDriver() {
        WebDriver driver = net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
