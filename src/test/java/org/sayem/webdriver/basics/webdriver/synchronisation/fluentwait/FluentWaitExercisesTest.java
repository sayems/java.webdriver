package org.sayem.webdriver.basics.webdriver.synchronisation.fluentwait;

import com.google.common.base.Function;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class FluentWaitExercisesTest {

    private static WebDriver driver;
    WebElement countdown;

    @BeforeClass
    public static void setup() {
        driver = Driver.get("http://compendiumdev.co.uk/selenium/javascript_countdown.html");
    }


    @Before
    public void setupTest() {

        if (Driver.currentDriver == Driver.BrowserName.OPERA) {
            // refreshing in Opera doesn't work reliably enough
            // The Old elements remain referenced so don't refresh for Opera, reload
            driver = Driver.get("http://compendiumdev.co.uk/selenium/javascript_countdown.html");
        } else {
            driver.navigate().refresh();
        }

        countdown = driver.findElement(By.id("javascript_countdown_time"));

        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOf(countdown));
    }

    @Test
    public void waitForWebElementFluently() {

        String theTime = new FluentWait<WebElement>(countdown).
                withTimeout(10, TimeUnit.SECONDS).
                pollingEvery(10, TimeUnit.MILLISECONDS).
                until(new Function<WebElement, String>() {
                          @Override
                          public String apply(WebElement element) {
                              return element.getText().endsWith("04") ? element.getText() : null;
                          }
                      }
                );

        assertEquals("Expected a different time", "01:01:04", theTime);
    }

    @Test
    public void waitForTimeWithWebDriverWaitFunction() {

        String theTime = new WebDriverWait(driver, 10, 100).
                until(new Function<WebDriver, String>() {
                          @Override
                          public String apply(WebDriver driver) {
                              WebElement countDown = driver.findElement(By.id("javascript_countdown_time"));
                              return countDown.getText().endsWith("04") ? countDown.getText() : null;
                          }
                      }
                );

        assertEquals("Expected a different time", "01:01:04", theTime);
    }

    @Test
    public void waitForTimeWithWebDriverWaitExpectedCondition() {

        String theTime = new WebDriverWait(driver, 10, 100).
                until(new ExpectedCondition<String>() {
                          @Override
                          public String apply(WebDriver driver) {
                              WebElement countDown = driver.findElement(By.id("javascript_countdown_time"));
                              return countDown.getText().endsWith("04") ? countDown.getText() : null;
                          }
                      }
                );

        assertEquals("Expected a different time", "01:01:04", theTime);
    }


}
