package com.sayem.synchronisation.webDriverWaitBasics;

import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;

public class WebDriverWaitExampleTest {

    @Test
    public void exampleUsingExpectedConditions(){

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                            "basic_html_form.html");

        new WebDriverWait(driver,10).until(
                ExpectedConditions.titleIs("HTML Form Elements"));

        assertEquals("HTML Form Elements", driver.getTitle());
    }

    @Test
    public void exampleWithSleepTime(){

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_html_form.html");

        new WebDriverWait(driver,10,50).until(
                ExpectedConditions.titleIs("HTML Form Elements"));

        assertEquals("HTML Form Elements", driver.getTitle());
    }
}
