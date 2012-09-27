package com.sayem.module14.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlert {

	/**
	 * @param args
	 */
	// http://code.google.com/p/selenium/wiki/FrequentlyAskedQuestions
	
	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("http://in.rediff.com");
		
		driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
		driver.findElement(By.xpath("//input[@id='btn_login']")).click();
		
		
		Alert javascriptAlert = driver.switchTo().alert();
		System.out.println(javascriptAlert.getText()); // text on alert box
		javascriptAlert.accept();
		//javascriptAlert.dismiss();
		
		
	}

}
