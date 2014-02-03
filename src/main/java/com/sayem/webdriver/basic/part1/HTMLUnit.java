package com.sayem.webdriver.basic.part1;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HTMLUnit {

    public static void main(String[] args) {

        // http://code.by.com/p/selenium/wiki/HtmlUnitDriver
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_10);
        driver.get("http://gmail.com");
        System.out.println(driver.getTitle());
    }

}
