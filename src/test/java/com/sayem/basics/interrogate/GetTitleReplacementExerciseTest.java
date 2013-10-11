package com.sayem.basics.interrogate;

import com.sayem.webdriver.examples.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GetTitleReplacementExerciseTest {

    static WebDriver driver;
    private final String pageTitle = "Welcome to the Find By Playground";

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        //driver = new FirefoxDriver();
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }

    @Test
    public void driverGetTitleSanity(){

        assertThat(pageTitle, is(driver.getTitle()));
    }

    @Test
    public void driverGetTitleWithTagName(){

        WebElement element;

        element = driver.findElement(By.tagName("title"));

        assertThat(pageTitle, is(element.getText()));
    }

    @Test
    public void driverGetTitleFromPageSource(){

        WebElement element;

        int titleStart = driver.getPageSource().toLowerCase().indexOf("<title>");
        int titleEnd = driver.getPageSource().toLowerCase().indexOf("</title>");
        String titleText = driver.getPageSource().substring(titleStart+7, titleEnd);

        assertThat(pageTitle, is(titleText));
    }

    @Test
    public void driverGetTitleWithXPathAbsolute(){

        WebElement element;

        element = driver.findElement(By.xpath("/html/head/title"));

        assertThat(pageTitle, is(element.getText()));
    }

    @Test
    public void driverGetTitleWithXPathAny(){

        WebElement element;

        element = driver.findElement(By.xpath("//title"));

        assertThat(pageTitle, is(element.getText()));
    }

    @Test
    public void driverGetTitleWithCSSAny(){

        WebElement element;

        element = driver.findElement(By.cssSelector("title"));

        assertThat(pageTitle, is(element.getText()));
    }

    @Test
    public void driverGetTitleWithCSSAbsolute(){

        WebElement element;

        element = driver.findElement(By.cssSelector("head > title"));

        assertThat(pageTitle, is(element.getText()));
    }

    /**
     * During the conversion of the tests to CI we found that IE does not like
     * starting CSS selectors at the html root so two of the tests have checks for IE
     * to prevent a known limitation impacting the CI run
     */
    @Test
    public void driverGetTitleWithCSSAbsoluteFromRoot(){

        // try catch block added for IE which does not like starting css at html
        try{

            WebElement element;

            element = driver.findElement(By.cssSelector("html > head > title"));

            assertThat(pageTitle, is(element.getText()));


            if(Driver.currentDriver == Driver.BrowserName.IE){
                throw new RuntimeException("IE now allows CSS starting at html");
            }

        }catch(NoSuchElementException e){
            if(Driver.currentDriver != Driver.BrowserName.IE){
                throw new RuntimeException("Expected only IE to fail on CSS starting at html");
            }
        }

    }

    @Test
    public void driverGetTitleWithCSSFromRootSkippingHead(){

        // try catch block added for IE which does not like starting css at html
        try{

            WebElement element;

            element = driver.findElement(By.cssSelector("html title"));

            assertThat(pageTitle, is(element.getText()));


            if(Driver.currentDriver == Driver.BrowserName.IE){
                throw new RuntimeException("IE now allows CSS starting at html");
            }

        }catch(NoSuchElementException e){
            if(Driver.currentDriver != Driver.BrowserName.IE){
                throw new RuntimeException("Expected only IE to fail on CSS starting at html");
            }
        }
    }


    @AfterClass
    public static void closeBrowser(){
        //driver.quit();
    }
}
