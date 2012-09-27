package com.sayem.module11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//FIREFOX PROFILE -> firefox.exe -profilemanager
//JAVADOC-> http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html?org/openqa/selenium/support/events/internal/EventFiringMouse.html
// FAQ on Selenium 2.0->http://code.google.com/p/selenium/wiki/FrequentlyAskedQuestions#Q:_How_do_I_execute_Javascript_directly?
public class WebDriver_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriver driver1 = new FirefoxDriver();
		WebDriver driver2 = new FirefoxDriver();
		WebDriver driver3 = new FirefoxDriver();
		//driver.get("http://gmail.com");
		
		driver1.get("http:gmail.com");
		driver2.get("http:google.com");
		//driver3.get("http:bbc.com");
		driver3.navigate().to("http:bbc.com");
		
		
		System.out.println(driver1.getTitle());
		System.out.println(driver2.getTitle());
		System.out.println(driver3.getTitle());
		
		
		//driver1.close();
		//driver2.close();
		//driver3.close(); // single window on which driver is having focus
		
		driver1.quit();
		driver2.quit();
		driver3.quit();  // close all windows opened by driver
		
		
		
		
		
		
		
		
	}

}
