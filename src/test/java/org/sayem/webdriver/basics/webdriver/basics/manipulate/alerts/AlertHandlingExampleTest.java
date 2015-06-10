package org.sayem.webdriver.basics.webdriver.basics.manipulate.alerts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class AlertHandlingExampleTest {

    private static WebDriver driver;


    @Before
    public void setup() {
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "alert.html");
    }

    @Test
    public void basicAlertHandlingExample() {

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

    }

}

