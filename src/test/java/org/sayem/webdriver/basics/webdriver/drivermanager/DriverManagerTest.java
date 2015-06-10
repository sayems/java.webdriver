package org.sayem.webdriver.basics.webdriver.drivermanager;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DriverManagerTest {

    WebDriver driver;

    @Test
    public void createAFirefoxDriver() {
        System.setProperty(DriverManager.SELENIUM2_BASICS_DRIVER, "firefox");
        assertBrowserTestRuns();
    }

    @Test
    public void createAnOperaDriver() {
        System.setProperty(DriverManager.SELENIUM2_BASICS_DRIVER, "opera");
        assertBrowserTestRuns();
    }

    @Test
    public void createAnHtmlUnitDriver() {
        System.setProperty(DriverManager.SELENIUM2_BASICS_DRIVER, "htmlunit");
        assertBrowserTestRuns();
    }

    @Test
    public void createADefaultDriver() {
        assertBrowserTestRuns();
    }

    public void assertBrowserTestRuns() {
        driver = DriverManager.get();
        driver.get("http://compendiumdev.co.uk/selenium/basic_web_page.html");
        assertThat(driver.getTitle(), is("Basic Web Page Title"));
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
