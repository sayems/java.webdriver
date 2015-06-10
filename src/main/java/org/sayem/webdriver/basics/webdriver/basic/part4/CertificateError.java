package org.sayem.webdriver.basics.webdriver.basic.part4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CertificateError {

    public static void main(String[] args) {
        //FirefoxProfile fp = new FirefoxProfile();
        //fp.setAcceptUntrustedCertificates(true);
        //fp.setAssumeUntrustedCertificateIssuer(false);


        //WebDriver driver = new FirefoxDriver(fp);
        System.setProperty("webdriver.chrome.driver", "H://chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://soapui-tutorial.com/login/soapui-memberlogin.php");
        driver.findElement(By.xpath("//input[@name='unamesoap']")).sendKeys("its.thakur@gmail.com");
        driver.findElement(By.xpath("//input[@name='pwordsoap']")).sendKeys("cool");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.xpath("html/body/table[3]/tbody/tr/td[1]/table/tbody/tr[4]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/a[1]/img")).click();

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> iter = ids.iterator();
        String mainWindowId = iter.next();
        String tabWindowId = iter.next();
        driver.switchTo().window(tabWindowId);
        driver.findElement(By.xpath("html/body/a[1]")).click();
        // certificate err
        // IE
        //driver.navigate().to("javascript:document.getElementById('overridelink').click()");

    }
}
