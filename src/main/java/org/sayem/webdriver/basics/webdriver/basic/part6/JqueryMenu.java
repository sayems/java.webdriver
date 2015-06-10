package org.sayem.webdriver.basics.webdriver.basic.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JqueryMenu {

    public static void main(String[] args) throws InterruptedException {
        //FirefoxProfile profile = new FirefoxProfile();
        //profile.setEnableNativeEvents(true);
        //WebDriver driver = new FirefoxDriver(profile);
        System.setProperty("webdriver.chrome.driver", "E:\\Tools\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://apycom.com/menus/16-deep-sky-blue.html");

        String xpath_root = "//*[@id='menu']/ul/li[2]/a/span";
        String xpath_sub = "//*[@id='menu']/ul/li[2]/span/div/ul[1]/li[2]/a/span";

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(xpath_root))).build().perform();
        Thread.sleep(1000L);
        //driver.findElement(By.xpath(xpath_root)).isSelected();

        driver.findElement(By.xpath(xpath_sub)).click();


        //new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(subMenu));

    }
}