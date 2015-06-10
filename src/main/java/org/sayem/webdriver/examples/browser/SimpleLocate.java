package org.sayem.webdriver.examples.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class SimpleLocate {

    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new ChromeDriver();

        File file = new File("src/form.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);

        dr.get(filePath);
        Thread.sleep(2000);

//		by_class id
        dr.findElement(By.id("inputEmail")).click();
        Thread.sleep(1000);

//		by_class name
        dr.findElement(By.name("password"));
        Thread.sleep(1000);

//		by_class tagname
        String classOfForm = dr.findElement(By.tagName("form")).getAttribute("class");
        System.out.printf("%s\n", classOfForm);
        Thread.sleep(1000);

//		by_class link text
        WebElement link = dr.findElement(By.linkText("register"));
        ((JavascriptExecutor) dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", link);
        Thread.sleep(1000);

//		by_class partial link test
        WebElement sameLink = dr.findElement(By.partialLinkText("reg"));
        ((JavascriptExecutor) dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", sameLink);
        Thread.sleep(1000);

//		by_class css selector
        WebElement div = dr.findElement(By.cssSelector(".controls"));
        ((JavascriptExecutor) dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", div);
        Thread.sleep(1000);

//		by_class xpath
        dr.findElement(By.xpath("/html/body/form/div[3]/div/label/input")).click();
        Thread.sleep(1000);

        System.out.println("browser will be close");
        dr.quit();
    }

}
