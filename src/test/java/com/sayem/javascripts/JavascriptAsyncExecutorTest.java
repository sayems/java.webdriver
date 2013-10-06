package com.sayem.javascripts;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;


public class JavascriptAsyncExecutorTest {


    private static WebDriver driver;


    @BeforeClass
    public static void setup(){
        driver = Driver.get("http://www.compendiumdev.co.uk/selenium/basic_ajax.html");
    }

    @Before
    public void resetBeforeTest(){

        driver.navigate().refresh();
    }

    // for hints see http://stackoverflow.com/questions/2857900/onhide-type-event-in-

    @Test
    public void syncOnAjaxGifRemovalViaAsync(){

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        JavascriptExecutor js =(JavascriptExecutor)driver;

        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        js.executeScript("window.webdrivercallback = function(){};" +
                //extend the jQuery hide method to call our callback when it hides the gif
                "var _oldhide = $.fn.hide;" +
                "$.fn.hide = function(speed, callback) {" +
                "    var retThis = _oldhide.apply(this,arguments);" +
                "    window.webdrivercallback.apply();" +
                "    return retThis;" +
                "};"
        );

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        // need to wait in here, can do it with async javascript
        js.executeAsyncScript("window.webdrivercallback = arguments[arguments.length - 1];");

        // then select Java
        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='23']")).click();

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23",languageWeUsed.getText());


    }



}
