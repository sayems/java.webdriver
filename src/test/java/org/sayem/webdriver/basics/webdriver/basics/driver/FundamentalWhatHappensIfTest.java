package org.sayem.webdriver.basics.webdriver.basics.driver;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * FAQ - what happens if, based on fundamental information
 */
@Ignore("Ignored because slow")
public class FundamentalWhatHappensIfTest {

    @Test
    public void whatHappensIfIQuitThenClose() {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));

        driver.quit();
        try {
            driver.close();
            fail("expected an UnreachableBrowserException");
        } catch (UnreachableBrowserException e) {
            assertTrue("We should get an UnreachableBrowserException if we close after quiting", true);
        }
    }


    @Test
    public void whatHappensIfICloseWithNothingOpen() {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));

        driver.close();
        driver.close();

        assertTrue("Nothing happens", true);

        driver.close();
        driver.close();
        driver.close();
        driver.close();
        driver.close();
        driver.close();
        driver.close();
        driver.close();

        assertTrue("See, Nothing happens, I can close as often as I want", true);
    }

    @Test
    public void whatHappensIfIForgetToNavigate() {
        WebDriver driver = new FirefoxDriver();

        assertTrue("Empty Title", driver.getTitle().isEmpty());

        driver.quit();

    }
}
