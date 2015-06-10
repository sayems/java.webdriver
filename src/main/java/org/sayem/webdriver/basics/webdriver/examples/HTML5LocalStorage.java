package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HTML5LocalStorage {

    String lastName;
    JavascriptExecutor jsExecutor;
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://dl.dropbox.com/u/55228056/html5storage.html");
    }

    @Test
    public void testHTML5LocalStorage() throws Exception {

        String lastName;

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get the current value of localStorage.lastname, this should be Smith
        lastName = (String) jsExecutor.executeScript("return localStorage.lastname;");
        assertEquals("Smith", lastName);

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