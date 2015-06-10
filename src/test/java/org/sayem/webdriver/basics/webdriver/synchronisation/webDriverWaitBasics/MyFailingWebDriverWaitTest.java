package org.sayem.webdriver.basics.webdriver.synchronisation.webDriverWaitBasics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class MyFailingWebDriverWaitTest {


    //@Ignore("With not waits, this test fails")
    // added expected to allow test to run in CI
    @Test(expected = NoSuchElementException.class)
    // Exercise: Feel The Pain
    public void chooseToCodeInJavaOnTheServerFromCombosNoSynchronisationExample() {

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        // then select Java
        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='23']")).click();

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23", languageWeUsed.getText());

    }


}
