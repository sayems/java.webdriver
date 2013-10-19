package com.sayem.basics.interrogate.findby;

import com.sayem.webdriver.examples.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class FindByCSSSelectorBasicExercisesTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        //driver = new FirefoxDriver();
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }

    @Test
    public void findByIdUsingCSS(){

        WebElement element;
        //element = driver.findElement(By.id("p31"));
        element = driver.findElement(By.cssSelector("#p31"));

        assertEquals("expected a match on id",
                     "pName31",
                     element.getAttribute("name"));
    }

    @Test
    public void findByNameUsingCSS(){

        WebElement element;
        //element = driver.findElement(By.name("ulName1"));
        element = driver.findElement(By.cssSelector("[name='ulName1']"));

        assertEquals("expected a different id",
                "ul1",
                element.getAttribute("id"));
    }

    @Test
    public void findByClassNameUsingCSS(){

        WebElement element;
        //element = driver.findElement(By.className("specialDiv"));
        element = driver.findElement(By.cssSelector(".specialDiv"));

        assertEquals("expected a different id",
                "div1",
                element.getAttribute("id"));
    }

    @Test
    public void findByTagNameUsingCSS(){

        WebElement element;
        //element = driver.findElement(By.tagName("li"));
        element = driver.findElement(By.cssSelector("li"));

        assertEquals("expected a different name",
                "liName1",
                element.getAttribute("name"));
    }

    @AfterClass
    public static void closeBrowser(){
        //driver.quit();
    }
}
