package com.sayem.webdriver.examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class DoubleClickTest {
	@Test
	public void testDoubleClick() throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://dl.dropbox.com/u/55228056/DoubleClickDemo.html");
			
		WebElement message = driver.findElement(By.id("message"));
			
		//Verify color is Blue
		assertEquals("rgb(0, 0, 255)",message.getCssValue("background-color").toString());
		
		Actions builder = new Actions(driver);
		builder.doubleClick(message).build().perform();
		
		//Verify Color is Yellow
		assertEquals("rgb(255, 255, 0)",message.getCssValue("background-color").toString());
		
		driver.close();
	}
}