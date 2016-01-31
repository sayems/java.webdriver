package org.sayem.webdriver.deprecated.javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Click {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://www.google.com");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.findElement(By.id("gbqfq")).sendKeys("Selenium");
        jse.executeScript("document.getElementById('gbqfba').click();");
    }
}
