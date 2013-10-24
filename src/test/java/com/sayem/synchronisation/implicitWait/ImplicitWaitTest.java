package com.sayem.synchronisation.implicitWait;

import com.sayem.webdriver.examples.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ImplicitWaitTest {

    private static WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_html_form.html");
    }

    @Test
    // Exercise: Feel The Pain
    public void chooseToCodeInJavaOnTheServerFromCombosImplicitWaitSynchronisationExample(){

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        // then select Java
        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='23']")).click();

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23",languageWeUsed.getText());

    }

    @Test
    public void withImplicitWaitOfZeroTheMissingElementsAreFastToFind(){

        fillFormAndSubmit();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        // wait for 0 seconds implicitly
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebElement checkbox1Result;
        WebElement checkbox3Result=null;

        long findTimeStart = 0L;
        long findTimeEnd = 0L;

        findTimeStart = System.currentTimeMillis();
        checkbox1Result = driver.findElement(By.id("_valuecheckboxes0"));
        findTimeEnd = System.currentTimeMillis();

        long totalTimeToFindElement = findTimeEnd - findTimeStart;

        System.out.println("Time to find an element " + totalTimeToFindElement);

        long nofindTimeStart=0L;
        long nofindTimeend=0L;

        try{
            nofindTimeStart = System.currentTimeMillis();
            checkbox3Result = driver.findElement(By.id("_valuecheckboxes2"));

        }catch(NoSuchElementException e){
            // expected missing element
            nofindTimeend = System.currentTimeMillis();
        }

        long totalTimeToNotFindElement = nofindTimeend - nofindTimeStart;

        assertTrue("expected element not found", checkbox3Result==null);

        System.out.println("Time to not find an element " + totalTimeToNotFindElement);

        // time to find is variable so this check is not always true
        //assertTrue("expected faster time to not find element",
        //        totalTimeToNotFindElement < totalTimeToFindElement);
    }


    @Test
    public void withImplicitWaitOfTenTheMissingElementsTakeAtLeastThatToNotFind(){

        fillFormAndSubmit();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        // wait for 10 seconds implicitly
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement checkbox1Result=null;
        WebElement checkbox3Result=null;

        long findTimeStart = 0L;
        long findTimeEnd = 0L;

        findTimeStart = System.currentTimeMillis();
        checkbox1Result = driver.findElement(By.id("_valuecheckboxes0"));
        findTimeEnd = System.currentTimeMillis();

        long totalTimeToFindElement = findTimeEnd - findTimeStart;

        System.out.println("Time to find an element " + totalTimeToFindElement);

        long nofindTimeStart=0L;
        long nofindTimeend=0L;

        try{
            nofindTimeStart = System.currentTimeMillis();
            checkbox3Result = driver.findElement(By.id("_valuecheckboxes2"));

        }catch(NoSuchElementException e){
            // expected missing element
            nofindTimeend = System.currentTimeMillis();
        }

        long totalTimeToNotFindElement = nofindTimeend - nofindTimeStart;

        System.out.println("Time to not find an element " + totalTimeToNotFindElement);

        // wait for 0 seconds implicitly by default
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        assertTrue("expected slower time to not find element",
                totalTimeToNotFindElement > totalTimeToFindElement);
        assertTrue("implicit wait time is included in time to not find",
                totalTimeToNotFindElement > 10000L);

    }


    private void fillFormAndSubmit() {
        WebElement checkBox1;
        WebElement checkBox3;

        checkBox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
        checkBox3 = driver.findElement(By.cssSelector("input[value='cb3']"));

        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        if(checkBox3.isSelected()){
            checkBox3.click();
        }


        WebElement submitButton;
        submitButton = driver.findElement(
                By.cssSelector(
                        "input[type='submit'][name='submitbutton']"));

        submitButton.click();
    }

    @After
    public void resetImplicitWait(){
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

}
