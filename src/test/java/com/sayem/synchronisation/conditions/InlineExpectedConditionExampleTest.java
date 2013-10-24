package com.sayem.synchronisation.conditions;

import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class InlineExpectedConditionExampleTest {


    @Test
    public void inlineCustomExpectedCondition(){

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        // use an anonymous class directly
        new WebDriverWait(driver,10).until(
                new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElement(
                                By.cssSelector("option[value='23']"))
                                     .isDisplayed();
                    }
                }
        );

        // then select Java
        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='23']")).click();

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23",languageWeUsed.getText());

    }


    @Test
    public void methodWrappedCustomExpectedConditionReturningWebElement(){

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        WebElement javaOption = new WebDriverWait(driver,10).until(optionWithValueDisplayed("23"));

        javaOption.click();

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23",languageWeUsed.getText());

    }

    private ExpectedCondition<WebElement> optionWithValueDisplayed(final String value) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(
                        By.cssSelector("option[value='" + value + "']"));
            }
        };
    }

}
