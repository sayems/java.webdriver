package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HTML5SessionStorage {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://dl.dropbox.com/u/55228056/html5storage.html");
    }

    @Test
    public void testHTML5SessionStorage() throws Exception {

        String clickcount;

        WebElement clickButton = driver.findElement(By.id("click"));
        WebElement clicksField = driver.findElement(By.id("clicks"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get current value of sessionStorage.clickcount, should be null
        clickcount = (String) jsExecutor.executeScript("return sessionStorage.clickcount;");
        assertEquals(null, clickcount);
        assertEquals("0", clicksField.getAttribute("value"));

        //Click the Button, this will increase the sessionStorage.clickcount value by_class 1
        clickButton.click();

        //Get current value of sessionStorage.clickcount, should be 1
        clickcount = (String) jsExecutor.executeScript("return sessionStorage.clickcount;");
        assertEquals("1", clickcount);
        assertEquals("1", clicksField.getAttribute("value"));
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}