package com.sayem.pageobjects.slowloadablecomponent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class ProcessedFormPage extends SlowLoadableComponent<ProcessedFormPage> {
    private WebDriver driver;


    public ProcessedFormPage(WebDriver aDriver) {
        super(new SystemClock(), 10);
        driver = aDriver;
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
