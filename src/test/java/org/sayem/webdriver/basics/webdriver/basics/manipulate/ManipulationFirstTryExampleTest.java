package org.sayem.webdriver.basics.webdriver.basics.manipulate;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class ManipulationFirstTryExampleTest {

    static WebDriver driver;

    @Test
    @Ignore("without waits this will only work in debug mode")
    public void manipulation1stTry() {

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        driver.findElement(By.cssSelector("option[value='3']")).click();

        // click Java in the language dropdown
        driver.findElement(By.cssSelector("option[value='23']")).click();

        driver.findElement(By.name("submitbutton")).click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23", languageWeUsed.getText());
    }


}
