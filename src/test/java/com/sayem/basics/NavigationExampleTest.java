package com.sayem.basics;

import com.sayem.webdriver.examples.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static org.junit.Assert.assertEquals;

public class NavigationExampleTest {

    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        //driver = new FirefoxDriver();
        driver = Driver.get();
    }

    @Test
    public void navigateWithNavigateTo(){
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/search.php");
        assertTrue(driver.getTitle().
                startsWith("Selenium Simplified Search Engine"));
    }

    @AfterClass
    public static void quitDriver(){
        //driver.quit();
    }
}
