package org.sayem.webdriver.basics.webdriver.basic.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Walmart {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.walmart.com/");


        WebElement rootNode = driver.findElement(By.xpath("//*[@id='topNavMenuItem-4']/a/span/span[3]/span"));
        Actions act = new Actions(driver);
        act.moveToElement(rootNode).build().perform();

    }

}
