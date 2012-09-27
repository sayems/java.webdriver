package com.sayem.module17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Google_Pagination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.google.com");
		driver.findElement(By.xpath("//*[@id='body']/center/form/table/tbody/tr/td/div/input")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id='body']/center/form/table/tbody/tr/td/span[1]/span/input")).click();
		
		//WebElement nextLink = driver.findElement(By.xpath("//*[@id='pnnext']/span[2]"));
		
		for(int i=2 ; i<=12 ; i++){
			WebElement cell = driver.findElement(By.xpath("//*[@id='nav']/tbody/tr/td["+i+"]"));
			List<WebElement> links = cell.findElements(By.tagName("a"));
			System.out.println("Total links -- "+links.size());
		}
		
		
		
		
		
	}

}
