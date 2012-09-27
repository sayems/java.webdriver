package com.sayem.module12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class WebList {


	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http:\\quikr.com");
		
		
		driver.findElement(By.xpath("//select[@id='categoryId']")).sendKeys("Goa");
		
		WebElement droplist = driver.findElement(By.xpath("//select[@id='categoryId']"));
		
		
		List<WebElement> options = droplist.findElements(By.tagName("option"));
		
		System.out.println(options.size());
		
		for(int i=0 ; i<options.size() ; i++){
			//WebElement o= options.get(i);
			System.out.println(options.get(i).getText()+  "  ----  "+ options.get(i).getAttribute("value"));
		}
		
		
		
		
		
	}

}
