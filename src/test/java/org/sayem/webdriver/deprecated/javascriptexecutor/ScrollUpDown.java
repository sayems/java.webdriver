package org.sayem.webdriver.deprecated.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ScrollUpDown {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(250, 0)"); // Scroll up
        js.executeScript("window.scrollBy(0,250)", ""); // Scroll down

    }
}
