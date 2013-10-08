package com.sayem.gettarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CloseBrowser {

	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		System.out.println("browser will be closed");
		
		dr.quit();	
		System.out.println("browser is closed");
	}

}
