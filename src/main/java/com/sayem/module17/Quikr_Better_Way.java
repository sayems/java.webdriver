package com.sayem.module17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Quikr_Better_Way {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.quikr.com");
		
		List<WebElement> link_boxes=driver.findElements(By.xpath("//*[@id='cats']"));
		System.out.println("Number of boxes "+link_boxes.size() );
		
		WebElement box = link_boxes.get(0);
		List<WebElement> links = box.findElements(By.tagName("a"));
		System.out.println("Total links are -- "+links.size() );
		
		for(int i=1 ; i<links.size();i++){
			System.out.println("*********************************************");
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
			//links.get(i).click();
			//Thread.sleep(4000L);
			//System.out.println(driver.getTitle());
			//driver.navigate().back();
		}
		
		
	}

}
