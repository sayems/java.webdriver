package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ExecuteJavaScript {
    @Test
    public void testJavaScriptCalls() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.by_class.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String title = (String) js.executeScript("return document.title");
        assertEquals("Google", title);

        long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
        assertEquals(42, links);

        driver.close();

    }
}