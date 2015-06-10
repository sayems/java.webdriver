package org.sayem.webdriver.basics.webdriver.basic.part4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        // implicit and explicit wait
        // implicit wait -  global timout
        // explicit wait - not a global timeout but - specific to an element
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.get("http://yahoo.com");
        driver.findElement(By.xpath("//input[@id='p_13838465-p']")).sendKeys("hello");
        // implicit and explicit
        //Thread.sleep(4000);
        String text = driver.findElement(By.xpath("//*[starts-with(@id,'yui_3_4_0_1_13629')]/ul/li[1]/a")).getText();
        System.out.println(text);

        // WebDriverWait, FluentWait

    }
}
