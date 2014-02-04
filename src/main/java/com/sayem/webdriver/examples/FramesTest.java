package com.sayem.webdriver.examples;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FramesTest {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/Frames.html");
	}
	
	@Test
	public void testFrameWithIdOrName()
	{
		//Activate the frame on left side using it's id attribute
		driver.switchTo().frame("left");
		
		//Get an element from the frame on left side and verify it's contents
		WebElement leftmsg = driver.findElement(By.tagName("p"));
		assertEquals("This is Left Frame", leftmsg.getText());
		
		//Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();
		
		//Activate the frame on right side using it's name attribute
		driver.switchTo().frame("right");
		
		//Get an element from the frame on right side and verify it's contents
		WebElement rightmsg = driver.findElement(By.tagName("p"));
		assertEquals("This is Right Frame", rightmsg.getText());
		
		//Activate the Page, this will move context from frame back to the Page	
		driver.switchTo().defaultContent();
		
	}
	
	@Test
	public void testFrameByIndex()
	{
		//Activate the frame in middle using it's index. Index starts at 0
		driver.switchTo().frame(1);
		
		//Get an element from the frame in the middle and verify it's contents
		WebElement leftmsg = driver.findElement(By.tagName("p"));
		assertEquals("This Frame doesn't have id or name", leftmsg.getText());
		
		//Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void testFrameByContents()
	{
		//Get all frames on the Page, created with <frame> tag
		List<WebElement> frames = driver.findElements(By.tagName("frame"));

		//In this example frame in the middle is activated by_class checking the contents
		//Activate frame and check if it has the desired content. If found perform the operations
		//if not, then switch back to the Page and continue checking next frame
		for(WebElement frame : frames) {
			//switchTo().frame() also accepts frame elements apart from id, name or index 
			driver.switchTo().frame(frame);
			if(driver.getPageSource().contains("This Frame doesn't have id or name")) {
				assertTrue("Middle Frame Found",true);
				break;
			}
			else
				driver.switchTo().defaultContent();
		}

		//Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void testIFrame()
	{
		//The frame on the right side has a nested iframe containing 'Twitter Follow' Button
		//Activate the frame on right side using it's name attribute
		driver.switchTo().frame("right");
		
		//Get the iframe element
		WebElement twitterframe = driver.findElement(By.tagName("iframe"));
		//Activate the iframe 
		driver.switchTo().frame(twitterframe);
		//Get and Click the follow button from iframe
		//a Popup Window will appear after click
		WebElement button = driver.findElement(By.id("follow-button"));
		button.click();
		
		//Store the handle of current driver window
		String currentWindow = driver.getWindowHandle(); 
		
		//The Twitter Popup does not have name or title. 
		//Script will get handles of all open windows and 
		//desired window will be activated by_class checking it's Title
		Set<String> allWindows = driver.getWindowHandles();
		if(!allWindows.isEmpty()) {
			for (String windowId : allWindows)
			{
				driver.switchTo().window(windowId);
				if (driver.getTitle().equals("Unmesh Gundecha (@upgundecha) on Twitter")) {
					assertTrue("Twitter Login Popup Window Found",true);
					driver.close();
					break;
				}
					
			}
		}
		//Switch back to original driver window
		driver.switchTo().window(currentWindow);
		//switch back to Page from the frame
		driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public static void tearDown()
	{
		//Close the Parent Popup Window
		driver.close();
		driver.quit();
	}
}
