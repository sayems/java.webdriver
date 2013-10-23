package com.sayem.pageobjects.refactorExampleOneExercise;

import com.sayem.webdriver.examples.Driver;
import com.sayem.pageobjects.refactorExampleOneExercise.pages.BasicAjaxPageObject;
import com.sayem.pageobjects.refactorExampleOneExercise.pages.ProcessedFormPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;

import java.net.MalformedURLException;

import static junit.framework.Assert.assertEquals;
import static com.sayem.pageobjects.refactorExampleOneExercise.pages.BasicAjaxPageObject.Category;
import static com.sayem.pageobjects.refactorExampleOneExercise.pages.BasicAjaxPageObject.Language;

public class BasicTestsRefactored {

    private static WebDriver driver;
    private BasicAjaxPageObject basicAjaxPage;

    @BeforeClass
    public static void setupTestClass() throws MalformedURLException {
        driver = Driver.get();
		// added when doing demo of the AndroidDriver
        //driver = new AndroidDriver("http://192.168.1.165:8080/wd/hub");
    }

    @AfterClass
    public static void tearDown(){
		// only if using android driver above
        //driver.quit();
    }

    @Before
    public void setupTest() throws MalformedURLException {

        basicAjaxPage = new BasicAjaxPageObject(driver);
        basicAjaxPage.get();
    }

    @Test
    public void chooseToCodeInJavaOnTheServerFromCombosSyncOnAjaxBusyExample(){

        basicAjaxPage.selectCategory(Category.SERVER);
        basicAjaxPage.selectLanguage(Language.JAVA);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedForm = new ProcessedFormPage(driver);
        processedForm.waitUntilPageIsLoaded();

        assertEquals("Expected Java code", Language.JAVA.value() + "", processedForm.getValueFor("language_id"));

    }

    @Test
    public void chooseToCodeInJavascriptOnTheWeb(){

        // workaround for the bug
        basicAjaxPage.selectCategory(Category.SERVER);
        basicAjaxPage.selectCategory(Category.WEB);

        basicAjaxPage.selectLanguage(Language.JAVASCRIPT);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedForm = new ProcessedFormPage(driver);
        processedForm.waitUntilPageIsLoaded();

        //TODO: this is a known bug, when the page is first created it has JavaScript 1, but server call is JavaScript 0
        assertEquals("Expected JavaScript code", String.valueOf(Language.JAVASCRIPT.value()), processedForm.getValueFor("language_id"));
    }

    @Test
    public void chooseToCodeInCppOnDesktop(){

        basicAjaxPage.selectCategory(Category.DESKTOP);

        basicAjaxPage.selectLanguage(Language.DESKTOP_Cpp);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedForm = new ProcessedFormPage(driver);
        processedForm.waitUntilPageIsLoaded();

        assertEquals("Expected Desktop CPP code", String.valueOf(Language.DESKTOP_Cpp.value()), processedForm.getValueFor("language_id"));
    }
}
