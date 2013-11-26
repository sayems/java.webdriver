package com.sayem.webdriver.basic.part1;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyExample {

    public static void main(String[] args) {


        Proxy proxy = new Proxy();
        proxy.setProxyAutoconfigUrl("http://freeproxyserver.net/");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        cap.setCapability(CapabilityType.PROXY, proxy);


        FirefoxDriver driver = new FirefoxDriver(cap);
        driver.get("http://gmail.com");


    }

}