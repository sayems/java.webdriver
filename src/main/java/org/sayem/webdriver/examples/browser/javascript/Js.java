package org.sayem.webdriver.examples.browser.javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Js {

    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new ChromeDriver();

        File file = new File("src/js.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);

        dr.get(filePath);
        Thread.sleep(1000);

        ((JavascriptExecutor) dr).executeScript("$('#tooltip').fadeOut();");
        Thread.sleep(1000);

        WebElement button = dr.findElement(By.className("btn"));
        ((JavascriptExecutor) dr).executeScript("$(arguments[0]).fadeOut();", button);


        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();
    }

}
