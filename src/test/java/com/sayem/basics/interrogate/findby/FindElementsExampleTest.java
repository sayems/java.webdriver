package com.sayem.basics.interrogate.findby;

import com.sayem.webdriver.examples.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindElementsExampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        //driver = new FirefoxDriver();
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }

    @Test
    public void returnAListOfElementsByClassName(){

        List<WebElement> elements;
        elements = driver.findElements(
                              By.className("normal"));


        Set<String> foundTags = new HashSet<String>();

        for(WebElement e : elements){
            // added the toLowerCase for Opera which returns tags in uppercase
            foundTags.add(e.getTagName().toLowerCase());
        }

        assertTrue("expected p tag", foundTags.contains("p"));
        assertTrue("expected ul tag", foundTags.contains("ul"));
        assertTrue("expected li tag", foundTags.contains("li"));
        assertTrue("expected a tag", foundTags.contains("a"));
        assertFalse("did not expect div tag", foundTags.contains("div"));
    }

    @AfterClass
    public static void closeBrowser(){
        //driver.quit();
    }
}
