package com.sayem.webdriver.basic.part7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GmailNumber {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.gmail.com");
        String oldVal="";

        while(true){
            String newVal=driver.findElement(By.xpath("//*[@id='quota']")).getText();

            if(!newVal.equals(oldVal)){
                System.out.println(newVal);
                oldVal=newVal;

            }
        }
    }

}
