package com.sayem.webdriver.basic.part3;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Radios {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.echoecho.com/htmlforms10.htm");

        List<WebElement> radios = driver.findElements(By.xpath("//input[@name='group1']"));
        System.out.println("Total radio buttons -> "+ radios.size());

        System.out.println(radios.get(0).getAttribute("checked"));
        System.out.println(radios.get(1).getAttribute("checked")); // true
        System.out.println(radios.get(2).getAttribute("checked"));
        radios.get(0).click();// milk
        System.out.println("**********************");
        System.out.println(radios.get(0).getAttribute("checked")); // true
        System.out.println(radios.get(1).getAttribute("checked"));
        System.out.println(radios.get(2).getAttribute("checked"));





    }

}
