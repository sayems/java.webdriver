package com.sayem;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest{

    // Create a new instance of a driver
    WebDriver driver = new FirefoxDriver();

    @Before
    public void setUp() {
        // Navigate to the right place
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.by_class.ca/");
    }

     @After
     public void tearDown(){
         // Close the browser
         driver.quit();
     }

}
