package org.sayem.webdriver.grid;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test1 {

    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) throws MalformedURLException {
        DesiredCapabilities cap = null;
        if (browser.equalsIgnoreCase("firefox")) {
            cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            //cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        }

        if (browser.equalsIgnoreCase("internet explorer")) {
            cap = DesiredCapabilities.internetExplorer();
            cap.setBrowserName("internet explorer");
            cap.setPlatform(org.openqa.selenium.Platform.ANY);
        }

        if (browser.equalsIgnoreCase("chrome")) {
            cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            cap.setPlatform(org.openqa.selenium.Platform.ANY);
        }


        driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), cap);

        driver.get("https://login.salesforce.com/");
    }

    @Test
    public void method1() {

        //create a new contact
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("sejal.bhayana@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("pass@1234");
        driver.findElement(By.xpath("//*[@id='Login']")).click();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='Contact_Tab']/a")).click();
        driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();

        driver.findElement(By.xpath("//*[@id='name_lastcon2']")).sendKeys("GridGrid");
        driver.findElement(By.xpath("//*[@id='con4']")).sendKeys("Acme");

        driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();

    }

    @Test
    public void method2() {
        driver.findElement(By.xpath("//*[@id='topButtonRow']/input[4]")).click();
        Alert al = driver.switchTo().alert();

        al.accept();
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

