package com.sayem.basics.driver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    @Test
    /**
     * We need to create a driver before we can do anything.
     *
     * HtmlUnitDriver is a headless browser implemented using HtmlUnit
     *
     * http://htmlunit.sourceforge.net/
     *
     * Advantages:
     * - Fast
     * - good for simple testing
     *
     * Disadvantages:
     * - does not handle JavaScript well
     *
     *
     */
    public void driverIsTheKing(){
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");

        assertTrue(driver.getTitle().startsWith(
                "Selenium Simplified"));

        // don't need to close an HtmlUnitDriver, garbage
        // collection will take care of it
    }

}
