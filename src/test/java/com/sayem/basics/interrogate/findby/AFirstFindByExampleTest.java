package com.sayem.basics.interrogate.findby;

import com.sayem.webdriver.examples.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class AFirstFindByExampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        //driver = new FirefoxDriver();
        driver = Driver.get();
        driver.get("http://www.compendiumdev.co.uk/" +
                "selenium/find_by_playground.php");
    }

    @Test
    public void findByID(){
        WebElement cParagraph = driver.findElement(By.id("p3"));
        assertEquals("This is c paragraph text",
                     cParagraph.getText());
    }

    @AfterClass
    public static void closeBrowser(){
        //driver.quit();
    }
}
