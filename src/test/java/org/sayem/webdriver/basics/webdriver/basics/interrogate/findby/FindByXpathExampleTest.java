package org.sayem.webdriver.basics.webdriver.basics.interrogate.findby;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindByXpathExampleTest {

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
    public void assertNumberOfParagraphs() {

        List<WebElement> elements;
        elements = driver.findElements(By.xpath("//p"));

        int nestedCount = 0;
        for (WebElement e : elements) {
            if (e.getText().contains("nested para")) {
                nestedCount++;
            }
        }
        assertEquals(16, nestedCount);
        assertEquals(41, elements.size());
    }

    @Test
    public void findSpecificPara() {

        WebElement element;
        element = driver.findElement(
                By.xpath("//p[@name='pName5']"));

        assertEquals("Expected matching id",
                "p5",
                element.getAttribute("id"));
    }

    @Test
    public void pathNavigation() {

        WebElement element;
        element = driver.findElement(
                By.xpath("//div[@id='div18']//a[@name='aName26']"));

        assertEquals("Expected matching id",
                "a26",
                element.getAttribute("id"));
    }

    @Test
    public void conditionalAttributes() {

        WebElement element;
        element = driver.findElement(
                By.xpath("//a[@name='aName26' and @class='normal']"));

        assertEquals("Expected matching id",
                "a26",
                element.getAttribute("id"));
    }
}
