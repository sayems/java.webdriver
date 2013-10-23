package com.sayem.pageobjects.slowloadablecomponent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicAjaxPageObject extends LoadableComponent<BasicAjaxPageObject> {

    WebDriver driver;

    public enum Category{
        WEB(1), DESKTOP(2), SERVER(3);

        private int dropDownValue;

        Category(int value){
            this.dropDownValue = value;
        }

        public int value(){
            return dropDownValue;
        }
    }

    public enum Language {
        JAVASCRIPT(0), VBSCRIPT(1), FLASH(2),
        COBOL(20), FORTRAN(21), SERVER_Cpp(22), JAVA(23),
        DESKTOP_Cpp(10), ASSEMBLER(11), C(12), VISUAL_BASIC(13);

        private int dropDownValue;

        Language(int value){
            this.dropDownValue = value;
        }

        public int value(){
            return dropDownValue;
        }
    }

    public BasicAjaxPageObject(WebDriver webDriver) {
        driver = webDriver;
    }

    @Override
    protected void load() {
        driver.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
    }

    @Override
    protected void isLoaded() throws Error {
        try{
            driver.findElement(By.id("combo1"));
        }catch(NoSuchElementException e){
            throw new Error("basic_ajax page not loaded");
        }
    }

    public void selectCategory(Category category) {
        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='" + category.value() + "']")).click();

        // wait until the option I want to click is present
        // we could also wait for the contents of the drop down to fill
        /*new WebDriverWait(driver,10).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("option[value='23']")));*/

        // instead wait for the ajax symbol

        // wait until the ajax symbol has gone
        // because then the drop down has populated

        new WebDriverWait(driver,10).until(ajaxActionIsComplete());
    }

    public ExpectedCondition<Boolean> ajaxActionIsComplete() {
        return ExpectedConditions.invisibilityOfElementLocated(
                By.id("ajaxBusy"));
    }

    public void selectLanguage(Language language) {

        // wait until the option I want to click is present
        /* added this as historical code just in case
        new WebDriverWait(driver,10).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("option[value='23']")));
        */

        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='" + language.value() + "']")).click();
    }

    public void clickCodeInIt() {
        // Submit the form
        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();
    }

}
