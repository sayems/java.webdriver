package com.sayem.synchronisation.conditions;

import com.google.common.base.Predicate;
import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;

public class WaitingExercisesUsingPredicateTest {

    static WebDriver driver;


    /*****************************
     * Using a Predicate
     ****************************/

    @Test
    public void customExpectedConditionForTitleDoesNotContainUsingClass(){

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_redirect.html");

        driver.findElement((By.id("delaygotobasic"))).click();

        new WebDriverWait(driver,8).until(new TitleDoesNotContain("Redirects"));

        assertEquals("Basic Web Page Title", driver.getTitle());
    }


    private class TitleDoesNotContain implements Predicate<WebDriver> {
        private String titleExcludes;

        public TitleDoesNotContain(String notContainThisString) {
            this.titleExcludes = notContainThisString;
        }

        @Override
        public boolean apply(WebDriver webDriver) {
            return !webDriver.getTitle().contains(this.titleExcludes);
        }
    }


    @Test
    public void customExpectedConditionForTitleDoesNotContainUsingMethod(){

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_redirect.html");

        driver.findElement((By.id("delaygotobasic"))).click();

        new WebDriverWait(driver,8).until(titleDoesNotContain("Redirects"));

        assertEquals("Basic Web Page Title", driver.getTitle());
    }

    private Predicate<WebDriver> titleDoesNotContain(String stringNotInTitle) {
        return new TitleDoesNotContain(stringNotInTitle);
    }

}
