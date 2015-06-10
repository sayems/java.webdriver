package org.sayem.webdriver.basics.webdriver.basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.basics.webdriver.examples.Driver;


/**
 * This is not a test in the main course.
 * <p>
 * It is a file that I add for experimenting with code.
 * <p>
 * It should be ignored.
 * <p>
 * The code in here may not actually work.
 */
@Ignore("Because this is a scratchpad and I only want to use it when I need it, it might have random stuff in it")
public class Scratchpad {

    private static WebDriver driver;


    @Before
    public void setup() {

        // frame example to base work on
        driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void myStuff() {

       /* Actions clickOnCB1 = new Actions(driver).
                            click(driver.findElement((By.cssSelector("input[value='cb1']"))));

        clickOnCB1.perform();
        clickOnCB1.perform();
        clickOnCB1.perform();

        System.out.println("BreakPoint");*/
    }

    @After
    public void cleanup() {
        driver.quit();
    }


}
