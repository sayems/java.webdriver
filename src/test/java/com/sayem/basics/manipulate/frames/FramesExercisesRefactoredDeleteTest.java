package com.sayem.basics.manipulate.frames;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FramesExercisesRefactoredDeleteTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup(){
        driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
    }

    @Test
    public void loadTheGreenPage(){
        assertThat(driver.getTitle(), is("Frameset Example Title (Example 6)"));

        // load the green page
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='green.html']")).click();

        wait.until(presenceOfElementLocated(By.cssSelector("h1[id='green']")));

        // click on "Back to original page"
        driver.findElement(By.cssSelector("a[href='content.html']")).click();

        // assert for presence of "<h1>Content</h1>"
        WebElement h1 = wait.until(presenceOfElementLocated(By.xpath("//h1[.='Content']")));

        assertThat(h1.getText(), is("Content"));
    }

    @Test
    public void workWithTheIFrame(){
        assertThat(driver.getTitle(), is("Frameset Example Title (Example 6)"));

        // click on "menu"."iFrames Example"
        driver.switchTo().frame("menu");
        driver.findElement(By.cssSelector("a[href='iframe.html']")).click();

        wait.until(titleIs("HTML Frames Example - iFrame Contents"));

        // click on Example 5 in the iFrame
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("a[href='frames_example_5.html']")).click();

        wait.until(titleIs("Frameset Example Title (Example 5)"));

        // then content.load main frames page
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='index.html']")).click();

        wait.until(titleIs("Frameset Example Title (Example 6)"));
    }
}
