package com.sayem.screenshots;


import com.sayem.webdriver.examples.Driver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class CanWeTakeScreenshotsTest {

    @Test
    public void canWeTakeAScreenshotCapabilitiesStyle(){
        Driver.set(Driver.BrowserName.FIREFOX);
        WebDriver driver = Driver.get("http://seleniumsimplified.com");

        if(((HasCapabilities)driver).getCapabilities().is(CapabilityType.TAKES_SCREENSHOT)){
            TakesScreenshot snapper = (TakesScreenshot)driver;
            File tempImageFile = snapper.getScreenshotAs(OutputType.FILE);

            assertThat(tempImageFile.length(), is(greaterThan(0L)));

            // use these lines in debug mode
            System.out.println("Temp file written to " + tempImageFile.getAbsolutePath());
            Driver.get("File://"+ tempImageFile.getAbsolutePath());
        }else{
            fail("Driver did not support screenshots");
        }
    }

    @Test
    public void canWeTakeAScreenshotExceptionStyle(){
        Driver.set(Driver.BrowserName.FIREFOX);
        WebDriver driver = Driver.get("http://seleniumsimplified.com");

        try{
            TakesScreenshot snapper = (TakesScreenshot)driver;
            File tempImageFile = snapper.getScreenshotAs(OutputType.FILE);

            assertThat(tempImageFile.length(), is(greaterThan(0L)));

            // use these lines in debug mode
            System.out.println("Temp file written to " + tempImageFile.getAbsolutePath());
            Driver.get("File://"+ tempImageFile.getAbsolutePath());

        }catch(ClassCastException e){
            // if we cannot cast it to TakesScreenshot we will get a ClassCastException
            System.out.println(e);
            fail("Driver did not support screenshots");
        }
    }

    @Test
    public void htmlUnitDoesNotDoScreenshotsViaCapabilities(){
        Driver.set(Driver.BrowserName.HTMLUNIT);
        WebDriver driver = Driver.get("http://seleniumsimplified.com");

        HasCapabilities capabilityDriver = (HasCapabilities)driver;

        if(capabilityDriver.getCapabilities().is(CapabilityType.TAKES_SCREENSHOT)){
            fail("Expected htmlunit to report false for takes_screenshot");
        }
    }

    @Test
    public void htmlUnitDoesNotDoScreenshotsViaException(){
        Driver.set(Driver.BrowserName.HTMLUNIT);
        WebDriver driver = Driver.get("http://seleniumsimplified.com");

        try{
            TakesScreenshot snapper = (TakesScreenshot)driver;
            fail("Expected htmlunit to not cast to takes_screenshot");

        }catch(ClassCastException e){
            // if we cannot cast it to TakesScreenshot we will get a ClassCastException
            System.out.println(e);
        }
    }

    @After
    public void quitDriver(){
        Driver.quit();
    }



}
