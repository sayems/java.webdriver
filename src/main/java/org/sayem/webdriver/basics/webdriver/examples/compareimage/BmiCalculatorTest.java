package org.sayem.webdriver.basics.webdriver.examples.compareimage;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BmiCalculatorTest {

    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
    }

    @Test
    public void testBmiCalculatorLayout() throws Exception {

        String scrFile = "c:\\screenshot.png";
        String baseScrFile = "c:\\baseScreenshot.png";

        //Open the BMI Calculator Page and get a Screen Shot of Page into a File
        driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(scrFile));

        try {
            //Verify baseline image with actual image
            assertEquals(CompareUtil.Result.Matched, CompareUtil.CompareImage(baseScrFile, scrFile));
        } catch (Error e) {
            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        //Close the browser
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
