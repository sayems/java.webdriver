package com.sayem.webdriver.basic.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class DragandDrop {

    public static void main(String[] args) {
        //FirefoxProfile profile = new FirefoxProfile();
        //profile.setEnableNativeEvents(true);
        //WebDriver driver = new FirefoxDriver(profile);

        System.setProperty("webdriver.chrome.driver", "E:\\Tools\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://jqueryui.com/demos/droppable/");
        Actions act = new Actions(driver);

        WebElement src = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dest = driver.findElement(By.xpath("//*[@id='droppable']"));

        act.dragAndDrop(src, dest).build().perform();

        System.out.println(driver.findElement(By.xpath("//*[@id='droppable']/p")).getText());
    }

}
