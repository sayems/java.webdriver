package org.sayem.webdriver.basics.webdriver.basics.interrogate.findby;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static org.junit.Assert.assertEquals;

public class AFirstFindByExampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage() {
        //driver = new FirefoxDriver();
        driver = Driver.get();
        driver.get("http://www.compendiumdev.co.uk/" +
                "selenium/find_by_playground.php");
    }

    @AfterClass
    public static void closeBrowser() {
        //driver.quit();
    }

    @Test
    public void findByID() {
        WebElement cParagraph = driver.findElement(By.id("p3"));
        assertEquals("This is c paragraph text",
                cParagraph.getText());
    }
}
