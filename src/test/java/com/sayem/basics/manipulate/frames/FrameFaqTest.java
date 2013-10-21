package com.sayem.basics.manipulate.frames;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class FrameFaqTest {

    private static WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.get("http://www.compendiumdev.co.uk/selenium/frames");
    }

    @Test
    public void whatHappensIfIDoNotSwitchTo(){
        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        // if you remove the switchTo then it won't find the element below
        //driver.switchTo().frame("menu");

        try{
            driver.findElement(By.cssSelector("a[href='frames_example_1.html']")).click();
            fail("I did not expect to find this");

        }catch(NoSuchElementException e){
            // ignore the exception we expected
            e.printStackTrace();
        }
    }

}
