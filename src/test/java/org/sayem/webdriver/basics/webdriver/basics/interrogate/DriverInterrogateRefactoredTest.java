package org.sayem.webdriver.basics.webdriver.basics.interrogate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class DriverInterrogateRefactoredTest {

    public static WebDriver driver;

    @BeforeClass
    public static void startDriver() {
        driver = Driver.get();
        //driver = new FirefoxDriver();
    }

    @AfterClass
    public static void stopDriver() {
        //driver.quit();
    }

    @Test
    public void driverLevelPageInterrogateMethods() {

        final String theTestPageURL =
                "http://www.compendiumdev.co.uk/selenium/basic_web_page.html";

        driver.navigate().to(theTestPageURL);

        assertThat(driver.getTitle(), is("Basic Web Page Title"));
        assertThat(driver.getCurrentUrl(), is(theTestPageURL));
        assertThat(driver.getPageSource(), containsString("A paragraph of text"));
    }

}
