package org.sayem.webdriver.deprecated.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick2 {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:/DoubleClick.html");
        WebElement dblClick = driver.findElement(By.name("dblClick"));

        Actions builder = new Actions(driver);
        builder.moveToElement(dblClick).doubleClick().perform();
    }
}
