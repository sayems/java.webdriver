package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NavTimingDemo {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void testBMICalculator_Perf() throws Exception {

        // Open the BMI Calculator Mobile Application
        driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //	Get the Load Event End
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");

        // Get the Navigation Event Start
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");

        // Difference between Load Event End and Navigation Event Start is Page Load Time
        System.out.println("Page Load Time is " + (loadEventEnd - navigationStart) / 1000 + " seconds.");

        WebElement height = driver.findElement(By.name("heightCMS"));
        height.sendKeys("181");

        WebElement weight = driver.findElement(By.name("weightKg"));
        weight.sendKeys("80");

        WebElement calculateButton = driver.findElement(By.id("Calculate"));
        calculateButton.click();

        try {

            WebElement bmi = driver.findElement(By.name("bmi"));
            assertEquals("24.4", bmi.getAttribute("value"));

            WebElement bmi_category = driver.findElement(By.name("bmi_category"));
            assertEquals("Normal", bmi_category.getAttribute("value"));

        } catch (Error e) {

            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        // Close the browser
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
