package org.sayem.webdriver.deprecated.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SwitchBetweenFrames {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://///vmware-host/Shared Folders/Desktop/IFrames.html");

        Actions action = new Actions(driver);

        driver.switchTo().frame(0);
        WebElement txt = driver.findElement(By.name("1"));
        txt.sendKeys("I'm Frame One");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        txt = driver.findElement(By.name("2"));
        txt.sendKeys("I'm Frame Two");
    }
}
