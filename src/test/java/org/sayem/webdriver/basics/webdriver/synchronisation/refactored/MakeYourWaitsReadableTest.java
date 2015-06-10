package org.sayem.webdriver.basics.webdriver.synchronisation.refactored;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MakeYourWaitsReadableTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setupForTest() {

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // instantiate your waits at the highest level you can, to reuse in the test
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void wrapAnonymousClassesInMethods() {

        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        // wait for a thing, then use it
        wait.until(optionWithValueDisplayed("23")).click();


        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23", languageWeUsed.getText());

    }

    // wrap your anonymous classes in a method
    // override toString
    private ExpectedCondition<WebElement> optionWithValueDisplayed(final String value) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(
                        By.cssSelector("option[value='" + value + "']"));
            }

            @Override
            public String toString() {
                return "option with value " + value + " displayed";
            }
        };
    }


    @Test
    public void importExpectedConditionMethodsStatically() {

        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        // wait for a thing, then use it
        // static import for the elementToBeClickable method
        WebElement javaOption = wait.until(elementToBeClickable(
                By.cssSelector("option[value='23']")));
        javaOption.click();

        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23", languageWeUsed.getText());
    }

}
