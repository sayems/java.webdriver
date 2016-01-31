package org.sayem.webdriver.deprecated.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class GetWindowName {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return window.name"));
    }
}