package com.sayem.webdriver.basic.part5;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload {

    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://salesforce.com");
        driver.findElement(By.xpath("//*[@id='button-login']")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("loadrunnerjmeter@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("pass@1234");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='File_Tab']/a")).click();
        driver.findElement(By.xpath("//input[@id='multiFileInput']")).sendKeys("C:\\screen.jpeg");
    }

}
