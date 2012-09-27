package com.sayem.module12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Selenium_Basics {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http:\\gmail.com");
		/*
		// username
		WebElement username_fld=driver.findElement(By.xpath("//*[@id='Email']"));
		username_fld.sendKeys("xxxxxxx");
		//password
		WebElement password=driver.findElement(By.xpath("//*[@id='Passwd']"));
		password.sendKeys("yyyyyy");
		// click button
		WebElement signin_button=driver.findElement(By.xpath("//*[@id='signIn']"));
		signin_button.click();
		*/
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("xxxxx");
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='signIn']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
	}

}
