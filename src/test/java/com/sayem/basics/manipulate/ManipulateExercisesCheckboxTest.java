package com.sayem.basics.manipulate;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class ManipulateExercisesCheckboxTest {

    private static WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                            "basic_html_form.html");
    }

    @Test
    public void submitFormWithOnlyCheckbox1SelectedFindElementException(){

        WebElement checkBox1;
        WebElement checkBox3;

        checkBox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
        checkBox3 = driver.findElement(By.cssSelector("input[value='cb3']"));

        // assumes checkBox1 is not selected
        // this is fine if we want to encode preconditions in each test
        // or we could test for preconditions on page directly and
        // have 1 test which fails on precondition failure, and all
        // interaction tests could be made robust
        checkBox1.click();

        //checkBox3 is selected by default, but we trust nothing
        if(checkBox3.isSelected()){
            checkBox3.click();
        }

        clickSubmitButton();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertCheckBoxResults();

    }

    /**
     * This example is the same as above but uses findElements instead of individual findElement
     */
    @Test
    public void submitFormWithOnlyCheckbox1SelectedFindElementsException(){

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[name='checkboxes[]']"));

        checkBoxes.get(0).click();

        if( checkBoxes.get(2).isSelected()){
            checkBoxes.get(2).click();
        }

        clickSubmitButton();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertCheckBoxResults();

    }



    @Test
    public void submitFormWithOnlyCheckbox1SelectedFindElementsIsEmpty(){

        WebElement checkBox1;
        WebElement checkBox3;

        checkBox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
        checkBox3 = driver.findElement(By.cssSelector("input[value='cb3']"));

        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        //checkBox3 is selected by default, but we trust nothing
        if(checkBox3.isSelected()){
            checkBox3.click();
        }

        clickSubmitButton();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertCheckBoxResults();
    }


    /**
     * Helper methods
     */
    private void assertCheckBoxResults() {
        WebElement checkbox1Result;
        WebElement checkbox3Result=null;

        checkbox1Result = driver.findElement(By.id("_valuecheckboxes0"));

        try{
            checkbox3Result = driver.findElement(By.id("_valuecheckboxes2"));
        }catch(NoSuchElementException e){
            // expected missing element
        }

        assertTrue("expected to find checkbox 1", checkbox1Result!=null);
        assertTrue("expected not to find checkbox 3", checkbox3Result==null);
    }


    private void clickSubmitButton() {
        WebElement submitButton;
        submitButton = driver.findElement(
                By.cssSelector(
                        "input[type='submit'][name='submitbutton']"));

        submitButton.click();
    }

}
