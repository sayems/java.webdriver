package com.sayem.by;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByCSSSelector2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement searchButton = driver.findElement(By
                .cssSelector("#flrs>a[href='/intl/en/about.html']"));
        System.out.println(searchButton.getText());
    }
}
