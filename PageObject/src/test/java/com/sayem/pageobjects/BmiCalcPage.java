package com.sayem.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.*;

public class BmiCalcPage extends LoadableComponent<BmiCalcPage> {
	
	private WebElement heightCMS;
	private WebElement weightKg;
	private WebElement Calculate;
	private WebElement bmi;
	private WebElement bmi_category;
	private WebDriver driver;
	private String url = "http://dl.dropbox.com/u/55228056/bmicalculator.html";
	private String title = "BMI Calculator";
	
	public BmiCalcPage() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load() {
		this.driver.get(url);
	}
	
	@Override
	protected void isLoaded()  {
		assertTrue(driver.getTitle().equals(title));
	}
	
	public void calculateBmi(String height, String weight) {
		heightCMS.sendKeys(height);
		weightKg.sendKeys(weight);
		Calculate.click();
	}
	
	public String getBmi() {
		return bmi.getAttribute("value");
	}
	
	public String getBmiCategory() {
		return bmi_category.getAttribute("value");
	}
	
	public void close() {
		this.driver.close();
	}
}
