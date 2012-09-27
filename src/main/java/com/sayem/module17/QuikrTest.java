package com.sayem.module17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class QuikrTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		String xpath_start="//*[@id='aa1']/div[1]/ul/li[";
		String xpath_end="]/a";
		
		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.quikr.com");
		
		for(int i=1 ;i<= 16 ; i++){
			driver.findElement(By.xpath(xpath_start+ i + xpath_end)).click();
			// wait for next page
			Thread.sleep(5000L);
			System.out.println(driver.getTitle());
		    driver.navigate().back();
		}
		
		
		
		
		
		
	}

}
