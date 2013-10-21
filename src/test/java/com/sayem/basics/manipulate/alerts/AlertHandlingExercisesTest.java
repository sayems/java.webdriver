package com.sayem.basics.manipulate.alerts;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class AlertHandlingExercisesTest {

    private static WebDriver driver;


    @Before
    public void setup(){
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                        "alerts.html");
    }

    @Test
    public void basicAlertHandlingTest(){

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
    }

    @Test
    public void basicAlertHandlingDismissTest(){

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
    }

    @Test
    public void basicConfirmHandlingAcceptTest(){

        WebElement confirmButton;
        WebElement confirmResult;

        confirmButton = driver.findElement(By.id("confirmexample"));
        confirmResult = driver.findElement(By.id("confirmreturn"));

        assertEquals("cret", confirmResult.getText());
        confirmButton.click();

        String alertMessage = "I am a confirm alert";

        Alert confirmAlert = driver.switchTo().alert();

        assertEquals(alertMessage,confirmAlert.getText());

        confirmAlert.accept();

        assertEquals("true", confirmResult.getText());
    }

    @Test
    public void basicConfirmHandlingDismissTest(){

        WebElement confirmButton;
        WebElement confirmResult;

        confirmButton = driver.findElement(By.id("confirmexample"));
        confirmResult = driver.findElement(By.id("confirmreturn"));

        assertEquals("cret", confirmResult.getText());
        confirmButton.click();

        String alertMessage = "I am a confirm alert";

        Alert confirmAlert = driver.switchTo().alert();

        assertEquals(alertMessage,confirmAlert.getText());

        confirmAlert.dismiss();

        assertEquals("false", confirmResult.getText());
    }

    @Test
    public void basicPromptConfirmHandlingAcceptTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        if(Driver.currentDriver != Driver.BrowserName.IE){
            // no point doing this in IE as we know it isn't the actual prompt
            assertEquals(alertMessage,promptAlert.getText());
        }

        promptAlert.accept();

        assertEquals("change me", promptResult.getText());
    }

    @Test
    public void basicPromptConfirmHandlingDismissTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        if(Driver.currentDriver == Driver.BrowserName.IE){
            // In IE the alert always returns "Script Prompt:" and not the
            // actual prompt text, so this line is just to alert me if the
            // functionality changes
            if(!promptAlert.getText().equals("Script Prompt:")){
                throw new RuntimeException("IE now does not do Script Prompt");
            }

        }else{
            // only check the alert prompt if not in IE
            assertEquals(alertMessage,promptAlert.getText());
        }

        promptAlert.dismiss();

        assertEquals("pret", promptResult.getText());
    }

    // send text to prompt
    @Test
    public void basicPromptConfirmHandlingChangeAndAcceptTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        if(Driver.currentDriver != Driver.BrowserName.IE){
            // no point doing this in IE as we know it isn't the actual prompt
            assertEquals(alertMessage,promptAlert.getText());
        }

        promptAlert.sendKeys("Hello");
        promptAlert.accept();

        assertEquals("Hello", promptResult.getText());
    }

    @Test
    public void basicPromptConfirmHandlingChangeAndDismissTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());
        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        if(Driver.currentDriver != Driver.BrowserName.IE){
            // no point doing this in IE as we know it isn't the actual prompt
            assertEquals(alertMessage,promptAlert.getText());
        }

        promptAlert.sendKeys("Hello");
        promptAlert.dismiss();

        assertEquals("pret", promptResult.getText());
    }

    // Q: what happens if I send text to alert?
    // A: ElementNotVisibleException  in Firefox
    // A: in Chrome the text is sent
    @Test
    public void basicAlertHandlingKeysTest(){

        WebElement alertButton;
        WebElement alertResult;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, driver.switchTo().alert().getText());

        if(Driver.currentDriver == Driver.BrowserName.FIREFOX){
            try{
                driver.switchTo().alert().sendKeys("Hello keys Accept");
                fail("expected a ElementNotVisibleException thrown");
            }catch(ElementNotVisibleException e){
                assertTrue("Expected to get an exception", true);
            }
        }

        if(Driver.currentDriver == Driver.BrowserName.GOOGLECHROME){
            // chrome seems happy to send in text to an alert
            driver.switchTo().alert().sendKeys("Hello keys Accept");
        }

        driver.switchTo().alert().accept();
    }

}

