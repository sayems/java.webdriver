package org.sayem.webdriver.basics.webdriver.basics.interrogate;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static org.junit.Assert.assertEquals;

public class WebElementInterrogationTest {

    @Test
    public void WebElementInterrogationBasics() {

        final WebDriver driver;
        final String theTestPageURL =
                "http://www.compendiumdev.co.uk" +
                        "/selenium/basic_web_page.html";

        //driver = new FirefoxDriver();
        driver = Driver.get();

        driver.navigate().to(theTestPageURL);

        WebElement para1 = driver.findElement(By.id("para1"));

        assertEquals(para1.getText(), "A paragraph of text");

        //driver.close();
    }
}
