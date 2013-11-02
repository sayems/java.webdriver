package com.sayem.webdriver.examples.jqueryuitab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JQueryUITabWidgetTest {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/jQueryUITabDemo.html");
	}

	@Test
	public void testjQueryUITabWidget() {
		try {
		
			JQueryUITab tab = new JQueryUITab(driver.findElement(By.cssSelector("div[id=MyTab][class^=ui-tabs]"))); 
			
			//Verify Tab Widget has 3 Tabs
			assertEquals(3,tab.getTabCount());
			
			//Verify Home Tab is selected
			assertEquals("Home",tab.getSelectedTab());
			
			//Select Options Tab and verify it is selected
			tab.selectTab("Options");
			assertEquals("Options",tab.getSelectedTab());
	
			//Select Admin Tab and verify it is selected
			tab.selectTab("Admin");
			assertEquals("Admin",tab.getSelectedTab());
		
			//Select Home Tab
			tab.selectTab("Home");
			
		} catch (Exception e) {
			   //Capture and append Exceptions/Errors
			   verificationErrors.append(e.toString());			
		}
	}
	
   @After
   public void tearDown() {
	   //Close the browser
	   driver.quit();
	 		
	   String verificationErrorString = verificationErrors.toString();
	   if (!"".equals(verificationErrorString)) {
		   fail(verificationErrorString);
	   }
   }
}