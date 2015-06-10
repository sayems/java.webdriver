package org.sayem.webdriver.basics.webdriver.javascripts;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class JavascriptExecutorExampleTest {

    @Test
    public void callAJavaScriptFunctionOnThePage() {
        WebDriver driver = Driver.get(
                "http://www.compendiumdev.co.uk/selenium/canvas_basic.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        int actionsCount = driver.findElements(
                By.cssSelector("#commandlist li")).size();
        assertEquals("By default app has 2 actions listed", 2, actionsCount);

        js.executeScript("draw(1, 150, 150,40, '#FF1C0A');");

        actionsCount = driver.findElements(
                By.cssSelector("#commandlist li")).size();
        assertEquals("Calling draw should add an action", 3, actionsCount);
    }


}
