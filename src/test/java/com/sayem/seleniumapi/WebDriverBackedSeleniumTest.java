package com.sayem.seleniumapi;


import com.thoughtworks.selenium.Selenium;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBackedSeleniumTest {

    @Test
    /*
      * Should be able to inject a driver into the WebDriverBackedSelenium object
      * and then use the Selenium interface.
      */
    public void SeleniumOneAPI_IsSupportedByWebDriverFirefox(){

        WebDriver driver = new FirefoxDriver();

        String baseUrl = "http://www.compendiumdev.co.uk";
        Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);

        selenium.open("/selenium");


        Assert.assertEquals(true, selenium.getTitle().startsWith("Selenium Simplified"));

        // according to official docs need to use .stop() otherwise JVM continues to run
        selenium.stop();


        // after a quit, you cannot use the Firefox driver
        driver.quit();
    }


}
