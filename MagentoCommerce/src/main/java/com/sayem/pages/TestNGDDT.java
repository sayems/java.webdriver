package com.sayem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestNGDDT {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();	

	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
			new Object[] {"160","45","17.6","Underweight"},
			new Object[] {"168","70","24.8","Normal"},
			new Object[] {"181","89","27.2","Overweight"},
			new Object[] {"178","100","31.6","Obesity"},
	    };
	}
  
	@BeforeTest
	public void setUp() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
		
	}
  
	@Test(dataProvider = "testData")
	public void testBMICalculator(String height, String weight, String bmi, String category) {
		try {
			
			
			WebElement heightField = driver.findElement(By.name("heightCMS"));
			heightField.clear();
			heightField.sendKeys(height);
			
			WebElement weightField = driver.findElement(By.name("weightKg"));
			weightField.clear();
			weightField.sendKeys(weight);
	
			WebElement calculateButton = driver.findElement(By.id("Calculate"));
			calculateButton.click();
		
			WebElement bmiLabel = driver.findElement(By.name("bmi"));
			assertEquals(bmiLabel.getAttribute("value"),bmi);
			
			WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
			assertEquals(bmiCategoryLabel.getAttribute("value"),category);
			
		} catch (Error e) {
			//Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}

	@AfterTest
	public void tearDown() {
		//Close the browser
		driver.quit();
				
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
