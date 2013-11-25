package com.sayem.webdriver.basic.part1;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnit {

    public static void main(String[] args) {

        // http://code.google.com/p/selenium/wiki/HtmlUnitDriver
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_10);
        driver.get("http://gmail.com");
        System.out.println(driver.getTitle());
    }

}
