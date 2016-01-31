package org.sayem.webdriver.deprecated.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickOnWebElement {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:/Selectable.html");
        WebElement one = driver.findElement(By.name("one"));
        WebElement eleven = driver.findElement(By.name("eleven"));
        WebElement five = driver.findElement(By.name("five"));

        int border = 1;
        int tileWidth = 100;
        int tileHeight = 80;

        Actions builder = new Actions(driver);
        //Click on One
        builder.click(one);
        builder.build().perform();

        // Click on Eleven.
        builder.click(eleven);
        builder.build().perform();

        //Click on Five
        builder.click(five);
        builder.build().perform();
    }
}
