package com.sayem.webdriver.basic.part5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableCSSSelector {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.timeanddate.com/worldclock/");

        String xpath="//table[@class='border2 lpad wa wc-tab ccols4']/tbody/tr[8]/td[3]/a";
        String cSelec="table[class='border2 lpad wa wc-tab ccols4'] tbody tr:nth-child(3) td:nth-child(3) a";
        System.out.println(driver.findElement(By.cssSelector(cSelec)).getText());
    }

}
