package org.sayem.webdriver.basics.webdriver.pageobjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class WithoutPageObjectsTest {

    private WebDriver driver;

    // This has local abstractions instead of page objects
    // We want to refactor this to page objects

    // All these tests do pretty much the same thing so we will change when we refactor


    @Test
    public void chooseToCodeInJavaOnTheServerFromCombosSyncOnAjaxBusyExample() {

        startBrowserAndSelectServer();

        // wait until the ajax symbol has gone
        // because then the drop down has populated
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.id("ajaxBusy")));

        selectJavaSubmitFormAndCheckResult();


    }

    @Test
    public void chooseToCodeInJavaOnTheServerFromCombosSyncOnOptionPresentExample() {

        startBrowserAndSelectServer();

        // wait until the option I want to click is present
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("option[value='23']")));

        // then select Java
        selectJavaSubmitFormAndCheckResult();

    }

    @Test
    public void chooseToCodeInJavaOnTheServerFromCombosSyncOnOptionVisibleExample() {

        startBrowserAndSelectServer();

        // wait until the option I want to click is visible
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("option[value='23']")));

        // then select Java
        selectJavaSubmitFormAndCheckResult();

    }

    @Test
    public void chooseToCodeInJavaOnTheServerFromCombosSyncOnOptionClickableExample() {

        startBrowserAndSelectServer();

        // wait until the option I want to click is visible
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("option[value='23']")));

        // then select Java
        selectJavaSubmitFormAndCheckResult();

    }

    private void startBrowserAndSelectServer() {
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();
    }

    private void selectJavaSubmitFormAndCheckResult() {
        // then select Java
        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='23']")).click();

        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Processed Form Details"));

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23", languageWeUsed.getText());
    }
}
