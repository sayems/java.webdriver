package com.sayem.webdriver.basic.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class Slider {

    public static void main(String[] args) {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);
        WebDriver driver = new FirefoxDriver(profile);
        driver.get("http://jqueryui.com/demos/slider/");

        WebElement scroll = driver.findElement(By.xpath("//*[@id='slider']/a"));

        Actions act = new Actions(driver);
        int x = scroll.getLocation().x;
        act.clickAndHold(scroll).dragAndDropBy(scroll, x, 300).build().perform();

    }

}
