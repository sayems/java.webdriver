package com.sayem.webdriver.examples;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HTML5CanvasDrawing {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/html5canvasdraw.html");
	}

	@Test
	public void testHTML5CanvasDrawing() throws Exception {
		
		//Get the HTML5 Canvas Element
		WebElement canvas = driver.findElement(By.id("imageTemp"));
		//Select the Pencil Tool
		Select drawtool = new Select(driver.findElement(By.id("dtool")));
		drawtool.selectByValue("pencil");
		
		//Create a Action Chain for Draw a shape on Canvas
		Actions builder = new Actions(driver);
		builder.clickAndHold(canvas).moveByOffset(10, 50).
									 moveByOffset(50,10).
									 moveByOffset(-10,-50).
									 moveByOffset(-50,-10).release().perform();
		
		//Get a screenshot of Canvas element after Drawing and compare it to the base version
		//to verify if the Drawing is performed
		FileUtils.copyFile(WebElementExtender.captureElementBitmap(canvas), new File("c:\\tmp\\post.png"));
		assertEquals(CompareUtil.Result.Matched, CompareUtil.CompareImage("c:\\tmp\\base_post.png","c:\\tmp\\post.png"));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}