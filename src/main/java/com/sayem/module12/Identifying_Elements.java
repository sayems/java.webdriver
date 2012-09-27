package com.sayem.module12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Identifying_Elements {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http:\\in.rediff.com");
		
		//driver.findElement(By.xpath("//*[@id='mobicon']")).click();
		//driver.findElement(By.id("mobicon")).click();
		//driver.findElement(By.linkText("Visit us on mobile")).click();
		//driver.findElement(By.partialLinkText(" us on mobile"));
		String text =driver.findElement(By.xpath("//*[@id='mobicon']")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("val");
		driver.findElement(By.id("Email")).sendKeys("val");
		driver.findElement(By.className("gaia le val")).sendKeys("val"); // fail
		
		//  <
		
		
		
		
		
	}

}
