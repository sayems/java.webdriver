package com.sayem.basics;

import com.sayem.webdriver.examples.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * This is not a test in the main course.
 *
 * It is a file that I add for experimenting with code.
 *
 * It should be ignored.
 *
 * The code in here may not actually work.
 */
@Ignore("Because this is a scratchpad and I only want to use it when I need it, it might have random stuff in it")
public class Scratchpad {

    private static WebDriver driver;


    @Before
    public void setup(){

        // frame example to base work on
        driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void myStuff(){

       /* Actions clickOnCB1 = new Actions(driver).
                            click(driver.findElement((By.cssSelector("input[value='cb1']"))));

        clickOnCB1.perform();
        clickOnCB1.perform();
        clickOnCB1.perform();

        System.out.println("BreakPoint");*/
    }

    @After
    public void cleanup(){
        driver.quit();
    }



}
