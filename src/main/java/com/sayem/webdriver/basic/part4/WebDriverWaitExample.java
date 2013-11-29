package com.sayem.webdriver.basic.part4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitExample {

    public static void main(String[] args) {

    WebDriver driver = new FirefoxDriver();
    // page loading timout
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver,20);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://www.commonfloor.com/apartments-for-sale");
    driver.findElement(By.xpath("//*[@id='sale_type_chzn']/a/span")).click();
    driver.findElement(By.xpath("//*[@id='sale_type_chzn_o_1']")).click();

    // wait for element to be present  ... 10 sec
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='listing_loader']/img")));
    System.out.println("A");
    // wait for it to disappear  .. 20  sec
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='listing_loader']/img")));
    System.out.println("B");


    new FluentWait<WebDriver>(driver)
            .withTimeout(10, TimeUnit.SECONDS)
    .pollingEvery(5, TimeUnit.SECONDS)
    .ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='listing_loader']/img")));


    new FluentWait<WebDriver>(driver)
            .withTimeout(20, TimeUnit.SECONDS)
    .pollingEvery(5, TimeUnit.SECONDS)
    .ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='listing_loader']/img")));



    FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
            .withTimeout(20, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS);



    fWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='listing_loader']/img")));


    }

}


