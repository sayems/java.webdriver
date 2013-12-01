package com.sayem.grid;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.testng.annotations.Parameters;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class TestApp2{

    public WebDriver driver;

    @Parameters({"browser"})


    @BeforeClass
    public void setup(String browser) throws MalformedURLException, InterruptedException{
        DesiredCapabilities capability=null;

        if(browser.equalsIgnoreCase("firefox")){
            System.out.println("firefox");
            capability= DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(org.openqa.selenium.Platform.ANY);
            //capability.setVersion("7.0.1");
        }

        if(browser.equalsIgnoreCase("internet explorer")){
            System.out.println("internet explorer");
            capability= DesiredCapabilities.internetExplorer();
            capability.setBrowserName("internet explorer");
            //capability.setPlatform(org.openqa.selenium.Platform.ANY);
            //capability.setVersion("");
        }

        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("chrome");
            System.setProperty("webdriver.chrome.driver", "d:\\chromedriver_win_16.0.902.0\\chromedriver.exe");
            // browser.add(setupDriver(new ChromeDriver()));
            capability= DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
            //capability.setVersion("");
        }

        System.out.println("A");
        driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), capability);
        System.out.println("B");
        driver.get("http://google.com");
        Thread.sleep(10000L);
    }



    @Test
    public void test_first() throws InterruptedException{
        Thread.sleep(3000);
        WebElement search_editbox   =   driver.findElement(By.name("q"));
        WebElement search_button    =   driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("first");
        search_button.click();
        System.out.println("first");
    }

    @Test
    public void test_second(){
        WebElement search_editbox   =   driver.findElement(By.name("q"));
        WebElement search_button    =   driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("second");
        search_button.click();
        System.out.println("second");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
