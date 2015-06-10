package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class AlertsTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/Alerts.html");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void testSimpleAlert() {
        //Clicking button will show a simple Alert with OK Button
        WebElement button = driver.findElement(By.id("simple"));
        button.click();

        try {

            //Get the Alert
            Alert alert = driver.switchTo().alert();

            //Get the Text displayed on Alert using getText() method of Alert class
            String textOnAlert = alert.getText();

            //Click OK button, by_class calling accept() method of Alert Class
            alert.accept();

            //Verify Alert displayed correct message to user
            assertEquals("Hello! I am an alert box!", textOnAlert);

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConfirmAccept() {
        //Clicking button will show a Confirmation Alert with OK and Cancel Button
        WebElement button = driver.findElement(By.id("confirm"));
        button.click();

        try {

            //Get the Alert
            Alert alert = driver.switchTo().alert();

            //Click OK button, by_class calling accept() method of Alert Class
            alert.accept();

            //Verify Page displays correct message on Accept
            WebElement message = driver.findElement(By.id("demo"));
            assertEquals("You Accepted Alert!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConfirmDismiss() {
        //Clicking button will show a Confirmation Alert with OK and Cancel Button
        WebElement button = driver.findElement(By.id("confirm"));
        button.click();

        try {

            //Get the Alert
            Alert alert = driver.switchTo().alert();

            //Click Cancel button, by_class calling dismiss() method of Alert Class
            alert.dismiss();

            //Verify Page displays correct message on Dismiss
            WebElement message = driver.findElement(By.id("demo"));
            assertEquals("You Dismissed Alert!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrompt() {
        //Clicking button will show a Prompt Alert asking user to enter
        //value/text with OK and Cancel Button
        WebElement button = driver.findElement(By.id("prompt"));
        button.click();

        try {

            //Get the Alert
            Alert alert = driver.switchTo().alert();

            //Enter some value on Prompt by_class calling sendKeys() method of Alert Class
            alert.sendKeys("Foo");

            //Click OK button, by_class calling accept() method of Alert Class
            alert.accept();

            //Verify Page displays message with value entered in Prompt
            WebElement message = driver.findElement(By.id("prompt_demo"));
            assertEquals("Hello Foo! How are you today?", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
}
