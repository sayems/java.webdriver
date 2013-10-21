package com.sayem.basics.manipulate.frames;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;

public class FramesExampleTest {

    private static WebDriver driver;


    @Before
    public void setup(){

        WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");
    }

    @Test
    public void switchToFrameExample(){

        WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        driver.switchTo().frame("menu");

        driver.findElement(By.cssSelector("a[href='frames_example_1.html']")).click();

        String titleForExample1 = "Frameset Example Title (Example 1)";

        new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS).
                until(ExpectedConditions.titleIs(titleForExample1));

        assertEquals(titleForExample1,driver.getTitle());
    }
}
