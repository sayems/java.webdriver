package org.sayem.webdriver.basics.webdriver.basic.part3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextFieldsButtons {

    public static void main(String[] args) {
        // write, read, clear
        String browser = "Chrome"; // properties
        WebDriver driver = null;

        if (browser.equals("Mozilla"))
            driver = new FirefoxDriver();
        else if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("IE")) {
            // exe path
        }


        driver.manage().window().maximize();
        driver.get("http://www.golfclubs.com/");
        String x = driver.findElement(By.xpath("//*[@id='search-input']")).getAttribute("value");
        System.out.println(x);// search
        driver.findElement(By.xpath("//*[@id='search-input']")).sendKeys("nokia");
        x = driver.findElement(By.xpath("//*[@id='search-input']")).getAttribute("value");
        System.out.println(x); // nokia
        driver.findElement(By.xpath("//*[@id='search-input']")).clear();// clear

        // buttons
        //click, read the text

        x = driver.findElement(By.xpath("//*[@id='email-signup-wide']/input[3]")).getAttribute("value");
        System.out.println(x);// button text

    }

}
