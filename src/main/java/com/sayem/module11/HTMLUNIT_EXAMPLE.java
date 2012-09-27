package com.sayem.module11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HTMLUNIT_EXAMPLE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get("http://www.gmail.com");
		System.out.println("Title is --  " +driver.getTitle());
		System.out.println("Current URL -- "+ driver.getCurrentUrl());
		System.out.println("Page source ---- ");
		System.out.println(driver.getPageSource());
		
		driver.quit();
	}

}
