package org.sayem.webdriver.examples.browser.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Frame {

    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new ChromeDriver();

        File file = new File("src/frame.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);

        dr.get(filePath);
        Thread.sleep(1000);

        dr.switchTo().frame("f1");
        dr.switchTo().frame("f2");
        dr.findElement(By.id("kw")).sendKeys("watir-webdriver");
        Thread.sleep(1000);

        dr.switchTo().defaultContent();

        dr.switchTo().frame("f1");
        dr.findElement(By.linkText("click")).click();

        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();
    }

}
