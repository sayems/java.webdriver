package com.sayem.basics.manipulate.windows;

import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class WindowsExercisesTest {

    // useful link on window/frame names http://www.webreference.com/js/tutorial1/names.html

    @Test
    public void switchBetweenWindows(){

        Driver.quit(); // dodgy in a suite - close everything down and start again
        WebDriver driver = Driver.get(
                    "http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();

        String newWindowHandle=framesWindowHandle;

        Iterator<String> aHandle = driver.getWindowHandles().iterator();
        // forgot to add hasNext, could lead to an infinite loop
        while(newWindowHandle.equals(framesWindowHandle) && aHandle.hasNext()){
            newWindowHandle = aHandle.next();
        }

        driver.switchTo().window(newWindowHandle);

        // added to see if this fixes synch problem when run in suite
        new WebDriverWait(driver,5L).until(ExpectedConditions.titleContains("Selenium Simplified"));

        assertTrue("Expected Selenium Simplified site",
                driver.getTitle().contains("Selenium Simplified"));

        driver.switchTo().window(framesWindowHandle);

        assertTrue("Expected Frames site",
                driver.getTitle().contains("Frameset Example"));


        // tidy up
        // For some reason I couldn't switch back to the window in IE
        // only put this hack in because the test hangs indefinitely if I don't
        if(Driver.currentDriver == Driver.BrowserName.IE){
            Driver.quit();
            return;
        }

        driver.switchTo().window(newWindowHandle);
        driver.close();
        driver.switchTo().window(framesWindowHandle);

    }

    @Test
    public void switchToByName(){

        Driver.quit(); // dodgy in a suite - close everything down and start again
        WebDriver driver = Driver.get(
                "http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[id='goevil']")).click();

        // IE Fails at this point, suspect I need to change context back to allow a reclick
        driver.findElement(By.cssSelector("a[target='compdev']")).click();

        driver.switchTo().window("compdev");
        assertTrue("Expected Software Testing", driver.getTitle().contains("Software Testing"));

        driver.switchTo().window("evil");
        assertTrue("Expected Evil Tester", driver.getTitle().contains("Evil Tester"));

        driver.switchTo().window(framesWindowHandle);
        assertTrue("Expected Frames site",
                driver.getTitle().contains("Frameset Example"));

        driver.switchTo().window("compdev");
        driver.close();
        assertEquals("Expected 2 windows left", 2, driver.getWindowHandles().size());

        driver.switchTo().window("evil");
        driver.close();
        assertEquals("Expected 1 window left", 1, driver.getWindowHandles().size());
    }
}
