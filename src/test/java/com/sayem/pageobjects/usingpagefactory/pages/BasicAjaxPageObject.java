package com.sayem.pageobjects.usingpagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicAjaxPageObject extends LoadableComponent<BasicAjaxPageObject> {

    WebDriver driver;

    @FindBy(how= How.ID, using="combo1")
    private WebElement categorySelect;

    @FindBy(how= How.ID, using="combo2")
    private WebElement languageSelect;

    @FindBy(how= How.NAME, using="submitbutton")
    private WebElement codeInIt;

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
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
    }

    @Override
    protected void isLoaded() throws Error {

        try{
            categorySelect.isDisplayed();
        }catch(NoSuchElementException e){
            throw new Error("basic_ajax page not loaded");
        }
    }

    public void selectCategory(Category category) {
        categorySelect.findElement(By.cssSelector("option[value='" + category.value() + "']")).click();
        new WebDriverWait(driver,10).until(ajaxActionIsComplete());
    }

    public ExpectedCondition<Boolean> ajaxActionIsComplete() {
        return ExpectedConditions.invisibilityOfElementLocated(
                By.id("ajaxBusy"));
    }

    public void selectLanguage(Language language) {
        languageSelect.findElement(By.cssSelector("option[value='" + language.value() + "']")).click();
    }

    public void clickCodeInIt() {
        codeInIt.click();
    }

}
