package org.sayem.webdriver.deprecated.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:/Sortable.html");

        Actions builder = new Actions(driver);
        // Move tile3 to the position of tile2
        builder.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0)
                .perform();
    }
}
