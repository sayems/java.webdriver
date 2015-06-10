package org.sayem.webdriver.basics.webdriver.basic.part3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class Facebook {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://facebook.com");
        List<WebElement> fields = driver.findElements(By.xpath("//input[@type='text' or @type='password']"));
        System.out.println(fields.size());

        fields.get(0).sendKeys("one");
        fields.get(1).sendKeys("two");
        fields.get(2).sendKeys("three");
        fields.get(4).sendKeys("four");


    }

}
