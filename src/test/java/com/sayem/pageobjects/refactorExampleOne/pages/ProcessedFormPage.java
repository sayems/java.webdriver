package com.sayem.pageobjects.refactorExampleOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessedFormPage {
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
}
