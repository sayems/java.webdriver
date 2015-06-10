package org.sayem.webdriver.basics.webdriver.synchronisation.conditions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CustomExpectedConditionsExampleTest {

    @Test
    public void customSynchronisationWithExpectedCondition() {

        WebDriver driver;

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        new WebDriverWait(driver, 10).until(
                new SelectContainsText(By.id("combo2"), "Java")
        );

        // then select Java
        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='23']")).click();

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23", languageWeUsed.getText());
    }


    private class SelectContainsText implements ExpectedCondition<Boolean> {
        private String textToFind;
        private By findBy;

        public SelectContainsText(final By comboFindBy, final String textToFind) {
            this.findBy = comboFindBy;
            this.textToFind = textToFind;
        }

        @Override
        public Boolean apply(WebDriver webDriver) {
            WebElement combo = webDriver.findElement(this.findBy);
            List<WebElement> options = combo.findElements(By.tagName("option"));

            for (WebElement anOption : options) {
                if (anOption.getText().equals(this.textToFind))
                    return true;
            }

            return false;
        }

        @Override
        public String toString() {
            return "select " + this.findBy + " to contain " + this.textToFind;
        }
    }

}
