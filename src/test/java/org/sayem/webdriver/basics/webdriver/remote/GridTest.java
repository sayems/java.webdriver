package org.sayem.webdriver.basics.webdriver.remote;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class GridTest {

    public static WebDriver driver = null;

    @BeforeClass
    public static void connectToGrid() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("platform", Platform.WINDOWS);


        try {
            // add url to environment variables to avoid releasing with source
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void stopGrid() {
        driver.quit();
    }

    @Test
    public void simpleInteraction() {
        driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/basic_html_form.html");

        WebElement checkBox1 = driver.findElement(
                By.cssSelector("input[value='cb1']"));

        assertFalse("Starts not selected",
                checkBox1.isSelected());

        checkBox1.click();

        assertTrue("Click selects",
                checkBox1.isSelected());
    }
}
