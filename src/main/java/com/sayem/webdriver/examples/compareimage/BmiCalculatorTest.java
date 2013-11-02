package com.sayem.webdriver.examples.compareimage;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

public class BmiCalculatorTest {
	
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception { 
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
	}

	@Test
	public void testBmiCalculatorLayout() throws Exception {
	
		String scrFile = "c:\\screenshot.png";
		String baseScrFile = "c:\\baseScreenshot.png";
		
		//Open the BMI Calculator Page and get a Screen Shot of Page into a File
		driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(scrFile));
		
		try {
			//Verify baseline image with actual image 
			assertEquals(CompareUtil.Result.Matched, CompareUtil.CompareImage(baseScrFile,scrFile));
		} catch (Error e) {
			//Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		//Close the browser
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
