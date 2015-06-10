package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowMaximize {
    @Test
    public void testRowSelectionUsingControlKey() throws Exception {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.by_class.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.quit();
    }
}
