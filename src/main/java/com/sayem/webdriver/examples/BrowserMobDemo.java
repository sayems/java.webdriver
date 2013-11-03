package com.sayem.webdriver.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.browsermob.core.har.Har;
import org.browsermob.proxy.ProxyServer;

import java.io.File;

public class BrowserMobDemo {
	
	public static void main(String[] args) throws Exception {
	
		// Start the BrowserMob Proxy
		ProxyServer server = new ProxyServer(9090);
		server.start();

		// Get the Selenium proxy object
		Proxy proxy = server.seleniumProxy();
		
		// Configure Desired capability for using Proxy Server
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);

		// Start the Browser up
		WebDriver driver = new FirefoxDriver(capabilities);
		
		// Create a new HAR with the label "bmiCalculator"
		server.newHar("bmiCalculator");

		// Open the BMI Calculator Application
		driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");

		WebElement height = driver.findElement(By.name("heightCMS"));
		height.sendKeys("181");
		
		WebElement weight = driver.findElement(By.name("weightKg"));
		weight.sendKeys("80");

		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();
		
		Thread.sleep(5000);
		
		// Get the HAR data
		Har har = server.getHar();

		// Write the HAR Data in a File
		File harFile = new File("C:\\bmiCalculator.har");
		har.writeTo(harFile);
		
		// Stop the BrowserMob Proxy Server
		server.stop();
		
		// Close the browser
		driver.quit();
				
	}
}
