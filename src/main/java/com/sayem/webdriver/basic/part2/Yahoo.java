package com.sayem.webdriver.basic.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Yahoo {

    public static void main(String[] args) throws InterruptedException {
        // text , properties, xls

        //System.setProperty("webdriver.chrome.driver", "H:\\chromedriver.exe");
        //ChromeDriver driver = new ChromeDriver();
        //FirefoxDriver driver = new FirefoxDriver();

        // HW
        String browser = "Mozilla"; // properties
        WebDriver driver = null;

        if(browser.equals("Mozilla"))
            driver = new FirefoxDriver();
        else if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equals("IE")){
            // exe path
        }


        driver.get("http://yahoo.com");
        driver.findElement(By.xpath("//input[@id='p_13838465-p']")).sendKeys("hello");
        // implicit and explicit
        Thread.sleep(4000);
        String text = driver.findElement(By.xpath("//*[starts-with(@id,'yui_3_4_0_1_136256')]/ul/li[1]/a")).getText();
        System.out.println(text);

        // interfacename = new calssImple();
    }

}