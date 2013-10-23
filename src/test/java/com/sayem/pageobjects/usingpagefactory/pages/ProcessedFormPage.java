package com.sayem.pageobjects.usingpagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessedFormPage extends LoadableComponent<ProcessedFormPage>{
    private WebDriver driver;

    public ProcessedFormPage(WebDriver aDriver) {
        driver = aDriver;
    }

    public void waitUntilPageIsLoaded() {
        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
    }

    public String getValueFor(String valueID) {
        WebElement fieldValueElement = driver.findElement(By.id("_value" + valueID));
        return fieldValueElement.getText();
    }


    @Override
    protected void load() {
        // We will never load a processed form, it will always be a result of another action
    }

    @Override
    protected void isLoaded() throws Error {
        if(!driver.getTitle().contentEquals("Processed Form Details")){
            throw new Error("Title was not 'Processed Form Details' it was " + driver.getTitle());
            //or
            //fail("Title was not 'Processed Form Details' it was " + driver.getTitle());
        }
    }
}
