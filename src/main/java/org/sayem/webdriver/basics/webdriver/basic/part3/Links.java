package org.sayem.webdriver.basics.webdriver.basic.part3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Links {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://bbc.com");

        String text = driver.findElement(By.xpath("//ul[@id='blq-nav-main']/li[2]/a")).getText();
        System.out.println(text);
        text = driver.findElement(By.cssSelector("ul[id='blq-nav-main'] li:nth-child(5) a")).getText();
        System.out.println(text);

        //driver.findElement(By.linkText("Knife attack in Xinjiang kills four")).click();
        //driver.findElement(By.partialLinkText("ck in Xinjiang ki"));

    }

}
