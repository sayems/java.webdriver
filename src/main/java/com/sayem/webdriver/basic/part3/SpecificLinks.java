package com.sayem.webdriver.basic.part3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SpecificLinks {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://bbc.com");
        WebElement box = driver.findElement(By.xpath("//*[@id='news_moreTopStories']"));
        List<WebElement> links = box.findElements(By.tagName("a"));
        System.out.println("Total links -> "+ links.size());

        for(int i=0;i<links.size();i++){
            System.out.println(links.get(i).getText());
            links.get(i).click();
            System.out.println(driver.getTitle());
            driver.get("http://bbc.com");
            // build cache
            box = driver.findElement(By.xpath("//*[@id='news_moreTopStories']"));
            links = box.findElements(By.tagName("a"));
            System.out.println("**********************************");
        }
    }
}