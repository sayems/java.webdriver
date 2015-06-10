package org.sayem.webdriver.examples.browser.status;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Status {

    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new ChromeDriver();

        File file = new File("src/status.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);

        dr.get(filePath);
        Thread.sleep(1000);

        WebElement textField = dr.findElement(By.name("user"));
        System.out.println(textField.isEnabled());

        System.out.println(dr.findElement(By.className("btn")).isEnabled());

        ((JavascriptExecutor) dr).executeScript("$(arguments[0]).hide()", textField);
        System.out.println(textField.isDisplayed());

        WebElement radio = dr.findElement(By.name("radio"));
        radio.click();
        System.out.println(radio.isSelected());

        try {
            dr.findElement(By.id("none"));
        } catch (NoSuchElementException e) {
            System.out.println("element does not exist");
        }

        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();
    }

}
