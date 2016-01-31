package org.sayem.webdriver.deprecated.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick2 {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:/ContextClick.html");
        WebElement contextMenu = driver.findElement(By.id("div-context"));

        Actions builder = new Actions(driver);
        builder.moveToElement(contextMenu).contextClick()
                .click(driver.findElement(By.name("Item 4"))).perform();
    }
}
