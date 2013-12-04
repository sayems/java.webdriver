package com.sayem.webdriver.basic.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Qtpselenium {

    public static void main(String[] args) {
        //FirefoxProfile prof = new FirefoxProfile();
        //prof.setEnableNativeEvents(true);

        //WebDriver driver = new FirefoxDriver(prof);
        System.setProperty("webdriver.chrome.driver", "E:\\Tools\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qtpselenium.com/");


        WebElement rootNode=driver.findElement(By.xpath("//*[@id='nav']/li[3]/a"));
        Actions act =new Actions(driver);
        act.moveToElement(rootNode).build().perform();
        driver.findElement(By.xpath("//*[@id='nav']/li[3]/ul/li[3]/a")).click();

    }

}
