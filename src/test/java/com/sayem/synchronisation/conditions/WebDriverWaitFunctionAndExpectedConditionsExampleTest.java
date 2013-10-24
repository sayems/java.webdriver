package com.sayem.synchronisation.conditions;

import com.google.common.base.Function;
import com.sayem.webdriver.examples.Driver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class WebDriverWaitFunctionAndExpectedConditionsExampleTest {

    private static WebDriver driver;
    WebElement countdown;

    @BeforeClass
    public static void setup(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/javascript_countdown.html");
    }

    @Test
    public void returnAStringFromWebDriverWaitFunction(){

        String theTime = new WebDriverWait(driver,10,100).
                until(new Function<WebDriver, String>() {
                    @Override
                    public String apply(WebDriver driver) {
                        return "01:01:04";
                    }
                }
                );

        assertEquals("Expected a different time", "01:01:04", theTime);
    }

    @Test
    public void returnAStringFromWebDriverWaitExpectedCondition(){

        String theTime = new WebDriverWait(driver,10,100).
                until(new ExpectedCondition<String>() {
                    @Override
                    public String apply(WebDriver driver) {
                        return "01:01:04";
                    }
                }
                );

        assertEquals("Expected a different time", "01:01:04", theTime);
    }


    @Test
    public void returnAStringFromWebDriverWaitExpectedConditionAsMethod(){

        String theTime = new WebDriverWait(driver,10,100).
                until(timeHasChangedTo("01:01:04")
                );

        assertEquals("Expected a different time", "01:01:04", theTime);
    }

    private ExpectedCondition<String> timeHasChangedTo(final String timeToReturn) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver driver) {
                return timeToReturn;
            }
        };
    }

}
