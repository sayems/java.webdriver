package org.sayem.webdriver.basics.webdriver.random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActionExample {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }


    @Test
    public void draggable() {
        driver.get("http://jqueryui.com/demos/draggable/");
        WebElement draggable = driver.findElement(By.id("draggable"));
        new Actions(driver).dragAndDropBy(draggable, 120, 120).build()
                .perform();
    }

    @Test
    public void droppable() {
        driver.get("http://jqueryui.com/demos/droppable/");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver).dragAndDrop(draggable, droppable).build()
                .perform();
    }

    @Test
    public void selectMultiple() throws InterruptedException {
        driver.get("http://jqueryui.com/demos/selectable/");
        List listItems = driver.findElements(By.cssSelector("ol#selectable *"));
        Actions builder = new Actions(driver);
        builder.clickAndHold((WebElement) listItems.get(1)).clickAndHold((WebElement) listItems.get(2)).click();
        Action selectMultiple = builder.build();
        selectMultiple.perform();
    }

    @Test
    public void sliding() {
        driver.get("http://jqueryui.com/demos/slider/");
        WebElement draggable = driver.findElement(By.className("ui-slider-handle"));
        new Actions(driver).dragAndDropBy(draggable, 120, 0).build()
                .perform();
    }
}