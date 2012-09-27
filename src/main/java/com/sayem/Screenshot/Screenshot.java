package com.sayem.Screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		
		for(int i=0 ; i< allLinks.size();i++){
			System.out.println(allLinks.get(i).getText());
		}
		System.out.println("**************************************************");
		
		WebElement footer = driver.findElement(By.xpath("//*[@id='footer']"));
		
		List<WebElement> footer_links = footer.findElements(By.tagName("a"));
		
		for(int i=0 ; i< footer_links.size();i++){
			System.out.println(footer_links.get(i).getText());
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("/Users/sayem/Pictures/google.jpg"));

		driver.quit();
		
	}

}