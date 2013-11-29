package com.sayem.webdriver.basic.part4;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JobserveTab {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "H://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        // main window
        driver.get("http://www.jobserve.com/in/en/Job-Search/");
        // total windows - 1
        Set<String> winIds = driver.getWindowHandles();
        System.out.println("Total browsers-> "+winIds.size());
        Iterator<String> it= winIds.iterator();
        System.out.println(it.next());

        driver.findElement(By.xpath("//*[@id='OtherSites']/p[1]/a[1]")).click();
        System.out.println("************************");
        // main and tab    --- main  - 2
        winIds = driver.getWindowHandles();
        System.out.println("Total windows->"+ winIds.size());
        it= winIds.iterator();
        String mainWindowId = it.next();
        String tabWinId = it.next();
        System.out.println(mainWindowId);
        System.out.println(tabWinId);

        driver.switchTo().window(tabWinId);

        driver.findElement(By.xpath("//input[@id='ctl00_OneColMain_uxSearchAndRefine_uxKeywords']")).sendKeys("hello");

        driver.close(); // tab window
        //driver.quit(); // close all the windows
        driver.switchTo().window(mainWindowId);

        // close - rediff popup
        // hdfc
    }

}
