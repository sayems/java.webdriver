package org.sayem.webdriver.deprecated.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*
 *  Please visit: http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/interactions/Actions.html
 *  to learn more about perform() method.
 */


public class ActionBuildPerform {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:/selectable.html");
        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));

        // Add all the actions into the Actions builder.
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(one).click(three).click(five)
                .keyUp(Keys.CONTROL);

        // Generate the composite action.
        Action compositeAction = builder.build();

        // Perform the composite action.
        compositeAction.perform();
    }
}