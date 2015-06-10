package org.sayem.webdriver.basics.webdriver.basics.interrogate.findby;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FirstFindByExercisesTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage() {
        //driver = new FirefoxDriver();
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }

    @AfterClass
    public static void closeBrowser() {
        //driver.quit();
    }

    @Test
    public void noSuchElementException_thrownWhenLocatorWrong() {

        try {
            // id is p3, name is p3Name, this will fail
            WebElement cParagraph = driver.findElement(By.id("p3Name"));

            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            // ignore, we wanted to find an exception
            // make sure you import the selenium exception
            // import org.openqa.selenium.NoSuchElementException;
            // and not the java.util.NoSuchElementException
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException_thrownWhenLocatorWrong_Expected() {

        // id is p3, name is p3Name, this will fail
        WebElement cParagraph = driver.findElement(By.id("p3Name"));

    }

    @Test
    public void findByID() {
        // match an element's id attribute
        WebElement cParagraph = driver.findElement(
                By.id("p3"));

        assertEquals("This is c paragraph text", cParagraph.getText());
    }

    @Test
    public void findByLinkText() {
        //look for an <a> via the text (i.e. getText)
        WebElement jumpToPara0 = driver.findElement(
                By.linkText("jump to para 0"));

        assertEquals("a26", jumpToPara0.getAttribute("id"));
    }

    @Test
    public void findByName() {
        // match an element's name attribute
        WebElement aParagraph = driver.findElement(
                By.name("pName1"));

        assertEquals("This is a paragraph text", aParagraph.getText());
    }

    @Test
    public void findByPartialLinkText() {
        // match an <a> using part of the link text

        // match beginning of text
        WebElement jump_to = driver.findElement(
                By.partialLinkText("jump to"));
        assertEquals("jump to para 0", jump_to.getText());

        // match middle of text
        jump_to = null;
        jump_to = driver.findElement(
                By.partialLinkText("to"));
        assertEquals("jump to para 0", jump_to.getText());

        // match at end of text
        jump_to = null;
        jump_to = driver.findElement(
                By.partialLinkText("7"));
        assertEquals("jump to para 7", jump_to.getText());
    }

    @Test
    public void findByClassName() {
        // match an element's class attribute
        WebElement aDiv = driver.findElement(
                By.className("specialDiv"));

        assertEquals("mydivname", aDiv.getAttribute("name"));
    }
}

