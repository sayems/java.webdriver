package org.sayem.webdriver.basics.webdriver.basic.part3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementPresence {

    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();
        driver.get("http://gmail.com");

        int count = driver.findElements(By.xpath("//*[@id='EmailXX']")).size();
        System.out.println(count);

    }

}