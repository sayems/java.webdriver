package com.sayem.basics.manipulate;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;

import static junit.framework.Assert.assertEquals;

public class ManipulateExercisesSubmitFileTest {

    private static WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                            "basic_html_form.html");
    }

    @Test
    public void submitFormWithAFile() throws URISyntaxException {

        WebElement filenameInput;

        filenameInput = driver.findElement(By.cssSelector("input[type='file']"));

        File testFile = new File(this.getClass().
                                    getResource("/testTextFile.txt").toURI());

        filenameInput.sendKeys(testFile.getAbsolutePath());

        clickSubmitButton();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertEquals("testTextFile.txt",
                     driver.findElement(By.id("_valuefilename")).getText());
    }

    private void clickSubmitButton(){
        WebElement submitButton;
        submitButton = driver.findElement(
                By.cssSelector(
                        "input[type='submit'][name='submitbutton']"));

        submitButton.click();
    }
}
