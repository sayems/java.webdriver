package com.sayem.module16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Fron_and_Back_Button {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.gmail.com");
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[1]/font/table/tbody/tr[3]/td[2]/font/a")).click();
		Thread.sleep(5000L);
		// back button
		driver.navigate().back();
		Thread.sleep(5000L);
		driver.navigate().forward();
		Thread.sleep(5000L);

		driver.quit();
		
		
		
		
		
	}

}
