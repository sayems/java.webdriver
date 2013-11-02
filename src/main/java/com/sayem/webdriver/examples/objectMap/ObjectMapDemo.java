package com.sayem.webdriver.examples.objectMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class ObjectMapDemo {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private ObjectMap map;
		
	@Before
	public void setUp() throws Exception { 
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
	}

	@Test
	public void testBmiCalculator() {
		try {
			//Get the Object Map File
			map = new ObjectMap("C:\\Users\\Admin\\workspace\\SeCookBook\\src\\objectmap.properties");
			
			//Get the Height element
			WebElement height = driver.findElement(map.getLocator("height_field"));;
			height.sendKeys("181");

			//Get the Weight element
			WebElement weight = driver.findElement(map.getLocator("weight_field"));
			weight.sendKeys("80");
	
			//Click on the Calculate button
			WebElement calculateButton = driver.findElement(map.getLocator("calculate_button"));
			calculateButton.click();
			
			//Verify the Bmi
			WebElement bmi = driver.findElement(map.getLocator("bmi_field"));
			assertEquals("24.4", bmi.getAttribute("value"));
			
		} catch (Exception e) {
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