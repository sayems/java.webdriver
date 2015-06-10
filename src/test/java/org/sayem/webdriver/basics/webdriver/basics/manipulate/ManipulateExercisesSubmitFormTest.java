package org.sayem.webdriver.basics.webdriver.basics.manipulate;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

public class ManipulateExercisesSubmitFormTest {

    private static WebDriver driver;

    @Before
    public void setup() {
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_html_form.html");
    }

    @Test
    public void submitFormWithButtonClick() {

        WebElement submitButton;
        submitButton = driver.findElement(
                By.cssSelector(
                        "input[type='submit'][name='submitbutton']"));

        submitButton.click();


        //when moving the test to continuous integration this check showed up as intermittent
        //assertEquals("Expected the form to be processed",
        //                "Processed Form Details",driver.getTitle());
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Processed Form Details"));
    }

    @Test
    public void submitFormWithButtonSubmit() {

        WebElement submitButton;
        submitButton = driver.findElement(
                By.cssSelector(
                        "input[type='submit'][name='submitbutton']"));

        submitButton.submit();

        //when moving the test to continuous integration this check showed up as intermittent
        //assertEquals("Expected the form to be processed",
        //                "Processed Form Details",driver.getTitle());
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Processed Form Details"));
    }

    @Test
    public void submitFormWithFormSubmit() {

        WebElement submitForm;
        submitForm = driver.findElement(
                By.id("HTMLFormElements"));

        submitForm.submit();

        //when moving the test to continuous integration this check showed up as intermittent
        //assertEquals("Expected the form to be processed",
        //                "Processed Form Details",driver.getTitle());
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Processed Form Details"));
    }

    @Test
    public void iCanActuallySubmitOnAnyFormElement() {
        WebElement passwordInput;
        passwordInput = driver.findElement(
                By.cssSelector("input[type='password']"));

        passwordInput.submit();

        //when moving the test to continuous integration this check showed up as intermittent
        //assertEquals("Expected the form to be processed",
        //                "Processed Form Details",driver.getTitle());
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Processed Form Details"));

    }

    @Test
    public void submitButtonWithKeyPress() {


        WebElement submitButton;
        submitButton = driver.findElement(
                By.cssSelector(
                        "input[type='submit'][name='submitbutton']"));


        //when moving the test to continuous integration this check showed up as intermittent
        //assertEquals("Expected the form to be processed",
        //                "Processed Form Details",driver.getTitle());

        // expect this to fail in Google Chrome and Opera
        // but did not pull this into a test exclusion - handling it via exception handling because it is a minor anomoly
        // not a major feature difference
        try {

            // enter used to work!
            //submitButton.sendKeys(Keys.ENTER);
            submitButton.sendKeys(Keys.SPACE);

            new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Processed Form Details"));

            // skip this test if Chrome - Chrome doesn't allow this
            if (Driver.currentDriver == Driver.BrowserName.GOOGLECHROME)
                throw new RuntimeException("Google Chrome now supports submit form with Keypress");
            if (Driver.currentDriver == Driver.BrowserName.OPERA)
                throw new RuntimeException("Opera now supports submit form with Keypress");

        } catch (WebDriverException e) {
            if ((Driver.currentDriver != Driver.BrowserName.GOOGLECHROME) || (Driver.currentDriver != Driver.BrowserName.OPERA)) {
                // ignore this as we expected a failure
            } else {
                throw new RuntimeException("A different browser does not support submit form with keypress", e);
            }
        }
    }


}
