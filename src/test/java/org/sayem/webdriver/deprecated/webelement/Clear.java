package org.sayem.webdriver.deprecated.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 *  Please visit: http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebElement.html
 *  to learn more about clear() method.
 */


public class Clear {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT, "packt publishing"));
        searchBox.clear();
    }
}