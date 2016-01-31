package org.sayem.webdriver.deprecated.by;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 *  Please visit: http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/By.html
 *  to learn more about By.ByPartialLinkText() method.
 */

public class ByPartialLinkText {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement aboutLink = driver.findElement(By.partialLinkText("About"));
        aboutLink.click();
    }
}