package org.sayem.webdriver.basics.webdriver.basics.navigation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class NavigationExampleTest {

    private static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        //driver = new FirefoxDriver();
        driver = Driver.get();
    }

    @AfterClass
    public static void quitDriver() {
        //driver.quit();
    }

    @Test
    public void navigateWithNavigateTo() {
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/search.php");
        assertTrue(driver.getTitle().
                startsWith("Selenium Simplified Search Engine"));
    }
}
