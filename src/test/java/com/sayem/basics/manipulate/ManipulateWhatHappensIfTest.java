package com.sayem.basics.manipulate;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;

public class ManipulateWhatHappensIfTest {

    private static WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                            "basic_html_form.html");
    }

    // note all the special case code in here because Opera claims to clear them (i.e. it doesn't throw an exception), but doesn't

    @Test
    public void canIClearACheckbox(){

        WebElement checkBox1;

        checkBox1 = driver.findElement(By.cssSelector("input[value='cb1']"));

        // select it
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        try{
            checkBox1.clear();


            if(Driver.currentDriver == Driver.BrowserName.OPERA){
                if(!checkBox1.isSelected()){
                   fail("Opera can now clear a checkbox");
                }
            }else{
                fail("Expected an exception as you can't clear a checkbox");
            }

        }catch(WebDriverException e){
            // expected an exception, you can't clear a multi select
            // you have to click to remove check
        }
    }

    @Test
    public void canIClearAMultiSelect(){

        WebElement multiSelect;

        multiSelect = driver.findElement(By.cssSelector("select[multiple='multiple']"));

        try{
            multiSelect.clear();

            if(Driver.currentDriver == Driver.BrowserName.OPERA){
                Select multi = new Select(multiSelect);

                if(multi.getAllSelectedOptions().size() == 0){
                    fail("Opera can now clear a multi select");
                }
            }else{
                fail("Expected an exception as you can't clear a multi select");
            }

        }catch(WebDriverException e){
            // expected an exception, you can't clear a multi select
            // you have to click to remove items
        }
    }

    @Test
    public void canIClearADropDownSelect(){

        WebElement dropDownSelect;

        dropDownSelect = driver.findElement(By.cssSelector("select[name='dropdown']"));

        try{
            dropDownSelect.clear();
            if(Driver.currentDriver == Driver.BrowserName.OPERA){
                Select dropDown = new Select(dropDownSelect);

                if(dropDown.getAllSelectedOptions().size() == 0){
                    fail("Opera can now clear a drop down select");
                }
            }else{
                fail("Expected an exception as you can't clear a drop down");
            }

        }catch(WebDriverException e){
            // expected an exception, you can't clear a drop down
            // you have to click to remove items
        }
    }

    @Test
    public void canIClearARadiobutton(){

        WebElement radioButton;

        radioButton = driver.findElement(By.cssSelector("input[value='rd2']"));

        try{
            radioButton.clear();

            if(Driver.currentDriver == Driver.BrowserName.OPERA){
                if(!radioButton.isSelected()){
                    fail("Opera can now clear a radio button");
                }
            }else{
                fail("Expected an exception as you can't clear a radio button");
            }

        }catch(WebDriverException e){
            // expected an exception, you can't clear a radio button
            // you have to click on another to remove selected
        }
    }
}
