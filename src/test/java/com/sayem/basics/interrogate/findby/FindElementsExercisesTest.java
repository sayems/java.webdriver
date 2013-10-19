package com.sayem.basics.interrogate.findby;

import com.sayem.webdriver.examples.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindElementsExercisesTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        //driver = new FirefoxDriver();
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }

    @Test
    public void doesFindElementsThrowAnExceptionIfNoMatch(){

        List<WebElement> elements;
        elements = driver.findElements(
                By.tagName("bob"));

        assertEquals(0,elements.size());
    }

    @Test
    public void assertDivElementsCount(){

        List<WebElement> elements;
        elements = driver.findElements(
                By.tagName("div"));

        assertEquals(19,elements.size());
    }


    @Test
    public void assert25LocalHrefLinks(){

        List<WebElement> elements;
        elements = driver.findElements(
                By.partialLinkText("jump to para"));

        assertEquals(25,elements.size());
    }

    @Test
    public void assertNumberOfParagraphs(){

        List<WebElement> elements;
        elements = driver.findElements(
                By.tagName("p"));

        int nestedCount = 0;
        for(WebElement e : elements){
            if(e.getText().contains("nested para")){
                nestedCount++;
            }
        }
        assertEquals(16,nestedCount);
        assertEquals(41, elements.size());
    }

    @AfterClass
    public static void closeBrowser(){
        //driver.quit();
    }


}
