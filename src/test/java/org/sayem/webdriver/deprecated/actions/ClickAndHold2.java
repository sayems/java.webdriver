package org.sayem.webdriver.deprecated.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold2 {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:/Sortable.html");
        WebElement three = driver.findElement(By.name("three"));

        Actions builder = new Actions(driver);
        // Move tile3 to the position of tile2
        builder.clickAndHold(three).moveByOffset(120, 0).perform();
    }
}
