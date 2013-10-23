package com.sayem.pageobjects.refactorExampleOne;

import com.sayem.pageobjects.refactorExampleOne.pages.BasicAjaxPageObject;
import com.sayem.pageobjects.refactorExampleOne.pages.ProcessedFormPage;
import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;
import static com.sayem.pageobjects.refactorExampleOne.pages.BasicAjaxPageObject.Category;

public class BasicTestsRefactored {

    private WebDriver driver;
    private BasicAjaxPageObject basicAjaxPage;

    @Before
    public void setupTest(){
        driver = Driver.get();
        basicAjaxPage = new BasicAjaxPageObject(driver);
        basicAjaxPage.get();
    }

    @Test
    public void chooseToCodeInJavaOnTheServerFromCombosSyncOnAjaxBusyExample(){

        basicAjaxPage.selectCategory(BasicAjaxPageObject.Category.SERVER);
        basicAjaxPage.selectLanguage(23);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.waitUntilPageIsLoaded();

        assertEquals("Expected Java code", "23",processedFormPage.getValueFor("language_id"));


    }

    @Ignore("exercise: investigate and fix this broken test")
    @Test
    public void chooseToCodeInJavascriptOnTheWeb(){

        basicAjaxPage.selectCategory(Category.WEB);
        basicAjaxPage.selectLanguage(0);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.waitUntilPageIsLoaded();

        assertEquals("Expected Javascript code", "0",processedFormPage.getValueFor("language_id"));

    }

    @Test
    public void chooseToCodeInCppOnDesktop(){

        basicAjaxPage.selectCategory(Category.DESKTOP);
        basicAjaxPage.selectLanguage(10);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.waitUntilPageIsLoaded();

        assertEquals("Expected Cpp code", "10",processedFormPage.getValueFor("language_id"));
    }

}
