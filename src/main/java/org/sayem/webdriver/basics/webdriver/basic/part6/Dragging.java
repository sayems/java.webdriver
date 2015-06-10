package org.sayem.webdriver.basics.webdriver.basic.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//http://code.by_class.com/p/selenium/wiki/AdvancedUserInteractions#Native_events_versus_synthetic_events
public class Dragging {

    public static void main(String[] args) {
        //FirefoxProfile profile = new FirefoxProfile();
        //profile.setEnableNativeEvents(true);
        //WebDriver driver = new FirefoxDriver(profile);

        System.setProperty("webdriver.chrome.driver", "E:\\Tools\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://jqueryui.com/demos/draggable/");
        WebElement obj = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions act = new Actions(driver);
        //act.dragAndDropBy(obj, 50, 50).build().perform();
        act.clickAndHold(obj).dragAndDropBy(obj, 200, 200).build().perform();
    }

}
