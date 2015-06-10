package org.sayem.webdriver.basics.webdriver.basic.part5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://in.rediff.com");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.xpath("//*[@id='btn_login']")).click();
        Thread.sleep(5000);
        org.openqa.selenium.Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        al.accept();//OK
        //al.dismiss();//cancel
        // switch to regular page
        driver.switchTo().defaultContent();
        // normal commands
    }

}
