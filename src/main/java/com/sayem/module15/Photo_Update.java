package com.sayem.module15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//http://www.jarvana.com/jarvana/view/org/seleniumhq/selenium/selenium-common/2.0a7/selenium-common-2.0a7-javadoc.jar!/org/openqa/selenium/Mouse.html
//http://code.google.com/p/selenium/wiki/AdvancedUserInteractions
//http://groups.google.com/group/selenium-developers/browse_thread/thread/fc2cd0d158d46c8e

public class Photo_Update {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("its.thakur@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("pass@1234");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='pagelet_welcome_box']/div/a/img")).click();
		driver.get("http://www.facebook.com/editprofile.php?sk=picture");
		
		driver.findElement(By.xpath("//*[@id='profile_picture_post_file']")).sendKeys("H:\\Documents and Settings\\Administrator\\Desktop\\Pic2.jpg");
		
		

	}

}
