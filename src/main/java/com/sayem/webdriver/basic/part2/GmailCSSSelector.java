package com.sayem.webdriver.basic.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailCSSSelector {

    public static void main(String[] args) {
        // XXXXXXAOOISHDIOA
        // ashdihasdiXXXXXXXXXXXXXasdasodasdoi

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://gmail.com");
        //driver.findElement(By.cssSelector("input[id='Email']")).sendKeys("ashish");
        //driver.findElement(By.cssSelector("input[id='Email'][name='Email']")).sendKeys("ashish");
        String x = driver.findElement(By.cssSelector("div[class='product-info mail'] p")).getText();
        System.out.println(x);
        driver.findElement(By.cssSelector("#Passwd")).sendKeys("password");

        // starts with
        //driver.findElement(By.cssSelector("input[name^='Ema']")).sendKeys("startswith");
        //driver.findElement(By.cssSelector("input[name$='ail']")).sendKeys("endswith");
        //driver.findElement(By.cssSelector("input[id*='mai']")).sendKeys("contains");
        driver.findElement(By.cssSelector("css=a:contains('Learn more')")).click();
    }
}
