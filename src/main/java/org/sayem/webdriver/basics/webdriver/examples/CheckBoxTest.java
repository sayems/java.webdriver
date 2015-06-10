package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckBoxTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/Config.html");
    }

    @Test
    public void testCheckBox() {
        //Get the Checkbox as WebElement using it's value attribute
        WebElement airbags = driver.findElement(By.xpath("//input[@value='Airbags']"));

        //Check if its already selected? otherwise select the Checkbox
        //by_class calling click() method
        if (!airbags.isSelected())
            airbags.click();

        //Verify Checkbox is Selected
        assertTrue(airbags.isSelected());

        //Check Checkbox if selected? If yes, deselect it
        //by_class calling click() method
        if (airbags.isSelected())
            airbags.click();

        //Verify Checkbox is Deselected
        assertFalse(airbags.isSelected());
    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}