package org.sayem.webdriver.basics.webdriver.basics.manipulate;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class SendKeysExamplesTest {

    private static WebDriver driver;

    @Before
    public void setup() {
        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                "basic_html_form.html");
    }

    @Test
    public void sendKeysModifierChord() {

        WebElement commentTextArea
                = driver.findElement(By.name("comments"));
        commentTextArea.clear();

        commentTextArea.sendKeys(Keys.chord(Keys.SHIFT, "bob", Keys.NULL, " Dobbs"));

        clickSubmitButton();

        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertExpectedCommentText("BOB Dobbs");
    }

    private void assertExpectedCommentText(String expectedCommentText) {
        WebElement commentsResults;

        commentsResults = driver.findElement(
                By.id("_valuecomments"));

        assertEquals("Expected to see " + expectedCommentText, expectedCommentText, commentsResults.getText());
    }

    private void clickSubmitButton() {
        WebElement submitButton;
        submitButton = driver.findElement(
                By.cssSelector(
                        "input[type='submit'][name='submitbutton']"));

        submitButton.click();
    }

}
