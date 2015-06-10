package org.sayem.webdriver.basics.webdriver.basics.driver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class FirstFirefoxTest {

    @Test
    /*
      * Physical browsers have to be closed, otherwise you will
      * have a bunch of browsers open on your screen.
      *
      * .close to close single window and browser if it is the last window
      * .quit to close browser and all windows
      */
    public void firefoxIsSupportedByWebDriver() {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");

        assertTrue(driver.getTitle().startsWith(
                "Selenium Simplified"));

        driver.close();

        // for early version combinations of Firefox and WebDriver we didn't need
        // .quit - I have added this line for the combination of WebDriver 2.31.0
        // and Firefox 20. According to the API we should not need to do a .quit
        // after a .close if there was only 1 window open. But sometimes the browser
        // version advances ahead of the WebDriver version and minor incompatibilities
        // happen.
        // Added the line below because of incompatibilite between 2.31.0 and Firefox 20
        // where a single window browser does not close when run from the IDE.
        driver.quit();
    }

}
