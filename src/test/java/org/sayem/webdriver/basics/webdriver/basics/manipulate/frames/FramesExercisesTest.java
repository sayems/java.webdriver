package org.sayem.webdriver.basics.webdriver.basics.manipulate.frames;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class FramesExercisesTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");
    }

    @Test
    public void loadTheGreenPage() {
        assertEquals("Frameset Example Title (Example 6)", driver.getTitle());

        // load the green page
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='green.html']")).click();

        new WebDriverWait(driver, Driver.DEFAULT_TIMEOUT_SECONDS).
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1[id='green']")));

        // click on "Back to original page"
        driver.findElement(By.cssSelector("a[href='content.html']")).click();

        // assert for presence of "<h1>Content</h1>"
        new WebDriverWait(driver, Driver.DEFAULT_TIMEOUT_SECONDS).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[.='Content']")));

        assertEquals("Content", driver.findElement(By.tagName("h1")).getText());
    }

    @Test
    public void workWithTheIFrame() {
        assertEquals("Frameset Example Title (Example 6)", driver.getTitle());

        // click on "menu"."iFrames Example"
        driver.switchTo().frame("menu");
        driver.findElement(By.cssSelector("a[href='iframe.html']")).click();

        new WebDriverWait(driver, Driver.DEFAULT_TIMEOUT_SECONDS).
                until(ExpectedConditions.titleIs("HTML Frames Example - iFrame Contents"));

        // click on Example 5 in the iFrame
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("a[href='frames_example_5.html']")).click();

        new WebDriverWait(driver, Driver.DEFAULT_TIMEOUT_SECONDS).
                until(ExpectedConditions.titleIs("Frameset Example Title (Example 5)"));

        // then content.load main frames page
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='index.html']")).click();

        new WebDriverWait(driver, Driver.DEFAULT_TIMEOUT_SECONDS).
                until(ExpectedConditions.titleIs("Frameset Example Title (Example 6)"));
    }
}
