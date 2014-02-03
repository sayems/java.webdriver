package com.sayem.webdriver.examples;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.fail;

public class RemoteWebDriverScreenShot {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception
	{
		DesiredCapabilities cap = new DesiredCapabilities();
			
		driver = new RemoteWebDriver(new URL("http://192.168.1.100:3001/wd/hub"),cap.ipad());
		driver.get("http://www.by.com");
	}

	@Test
	public void testRemoteDriverScreenShot() throws Exception {
		
		Thread.sleep(1000);
		driver = new Augmenter().augment(driver);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		
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