package com.sayem.webdriver.basic.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BBC {

    @Test
    public void testBBC(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://bbc.com");
        driver.findElement(By.xpath("//a[text()='Asia News']")).click();
        System.out.println(driver.getTitle());


    }
}
