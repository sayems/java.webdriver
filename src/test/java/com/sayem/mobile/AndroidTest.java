package com.sayem.mobile;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;

import java.net.MalformedURLException;

public class AndroidTest {

    // after installing the android server for webdriver
    // and finding the ip address from settings
    //@Ignore("setup with the IP of your device")
    @Test
    public void BasicAndroidTest() throws MalformedURLException {
        WebDriver driver = new AndroidDriver("http://192.168.1.165:8080/wd/hub");
        driver.get("http://seleniumsimplified.com");
        driver.quit();
    }
}
