package org.sayem.webdriver.examples.browser.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Navs {

    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new ChromeDriver();

        File file = new File("src/navs.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);

        dr.get(filePath);
        Thread.sleep(1000);

        dr.findElement(By.className("nav")).findElement(By.linkText("About")).click();
        Thread.sleep(1000);

        dr.findElement(By.linkText("Home")).click();

        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();
    }

}
