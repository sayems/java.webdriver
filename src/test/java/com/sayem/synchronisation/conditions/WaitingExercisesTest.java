package com.sayem.synchronisation.conditions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;

public class WaitingExercisesTest {

    static WebDriver driver;

    @Test
    public void canReturnAWebElementInsteadOfABooleanUsingAnonymousClass(){

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        // Wait for Java to be available to select
        WebElement elly = new WebDriverWait(driver,10).until(
                new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver webDriver) {

                        WebElement eli = webDriver.findElement(
                                By.cssSelector("option[value='23']"));

                        if(eli.isDisplayed()){
                            return eli;
                        }else{
                            return null;
                        }
                    }
                }
        );

        // select java
        elly.click();
        assertEquals("Expected Java", "Java", elly.getText());

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23",languageWeUsed.getText());
    }


    @Test
    public void customExpectedConditionForTitleDoesNotContainUsingClass(){

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_redirect.html");

        driver.findElement((By.id("delaygotobasic"))).click();

        assertEquals("Basic Web Page Title",
                new WebDriverWait(driver,8).until(
                        new TitleDoesNotContain("Redirects")));
    }


    private class TitleDoesNotContain implements ExpectedCondition<String> {
        private String titleExcludes;

        public TitleDoesNotContain(String notContainThisString) {
            this.titleExcludes = notContainThisString;
        }

        @Override
        public String apply(WebDriver webDriver) {
            String title = webDriver.getTitle();

            if(title.contains(this.titleExcludes)){
                return null;
            }else{
                return title;
            }
        }
    }


    // Note: I am also assigning wait to a variable
    @Test
    public void customExpectedConditionForTitleDoesNotContainUsingMethod(){

        WebDriverWait wait;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_redirect.html");
        wait = new WebDriverWait(driver,8);

        driver.findElement((By.id("delaygotobasic"))).click();

        assertEquals("Basic Web Page Title",
                wait.until(titleDoesNotContainF("Redirects")));
    }

    private ExpectedCondition<String> titleDoesNotContainF(String stringNotInTitle) {
        return new TitleDoesNotContain(stringNotInTitle);
    }


    @Test
    public void customExpectedConditionForTitleDoesNotContainUsingMethodAC(){

        WebDriverWait wait;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_redirect.html");
        wait = new WebDriverWait(driver,8);

        driver.findElement((By.id("delaygotobasic"))).click();

        assertEquals("Basic Web Page Title",
                wait.until(titleDoesNotContainAC("Redirects")));
    }

    private ExpectedCondition<String> titleDoesNotContainAC(final String stringNotInTitle) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver webDriver) {
                String title = webDriver.getTitle();

                if(title.contains(stringNotInTitle)){
                    return null;
                }else{
                    return title;
                }
            }
        };
    }
}
