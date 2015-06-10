package org.sayem.webdriver.examples.browser.attribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Attribute {

    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new ChromeDriver();

        File file = new File("src/attribute.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);

        dr.get(filePath);
        Thread.sleep(1000);

        WebElement link = dr.findElement(By.id("tooltip"));

        System.out.println(link.getAttribute("data-original-title"));

        System.out.println(link.getText());

        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();
    }

}
