package com.sayem.module14.simulatingkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keys_ex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("uuuuu");
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("pppp");
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys(Keys.ENTER);
	}

}
