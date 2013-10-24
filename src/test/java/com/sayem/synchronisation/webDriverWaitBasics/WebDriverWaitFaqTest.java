package com.sayem.synchronisation.webDriverWaitBasics;

import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class WebDriverWaitFaqTest {

    @Test
    public void whatIfTheExpectedConditionDoesNotMatch(){

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_html_form.html");

        try{
            new WebDriverWait(driver,10).until(
                ExpectedConditions.titleIs("HTML Form Elementals"));

            fail("Expected a org.openqa.selenium.TimeoutException");

        }catch(TimeoutException e){
            // ignore the timeout exception
        }
    }
}
