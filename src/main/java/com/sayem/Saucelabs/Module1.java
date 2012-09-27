package com.sayem.Saucelabs;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Module1 extends TestCase {
    private WebDriver Login;

    public void setUp() throws Exception {
        DesiredCapabilities capabillities = DesiredCapabilities.firefox();
        capabillities.setCapability("version", "6");
        capabillities.setCapability("platform", Platform.XP);
        capabillities.setCapability("name", "Testing Selenium 2 with Java on Sauce");

        this.Login = new RemoteWebDriver(
           new URL("http://sayem:xxxxxxxxxxx@ondemand.saucelabs.com:4444/wd/hub"),
           capabillities);
        Login.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void testSauce() throws Exception {
        this.Login.get("http://google.com");
        Thread.sleep(2000);
		Login.findElement(By.name("email")).sendKeys("sayem@gmail.com");
		Login.findElement(By.name("password")).sendKeys("xxxxxx");
		Login.findElement(By.id("login")).click();
	}

}   
