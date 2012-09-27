package com.sayem.module17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class Scrolling_Bar {


	public static void main(String[] args) throws InterruptedException {

		
		WebDriver d = new FirefoxDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(d);
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("its.thakur@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("pass@1234");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='pagelet_welcome_box']/div/a/img")).click();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//*[@id='pagelet_relationships']/div[2]/div/div/div[2]/h5/span/a")).click();
		Thread.sleep(5000L);
		//driver.executeScript("alert('hello friend list has loaded')");
		//driver.executeScript("scroll(0,20000)");
		// expand the friend list
		while(true){
			try{
				WebElement seeMore = driver.findElement(By.linkText("See more"));
				seeMore.click();
				Thread.sleep(5000L);
			}catch(Throwable t){
				System.out.println(" Expanded everything ");
				break;
			}
			
			
		}
		// logic the print the names
		WebElement box =driver.findElement(By.xpath("//*[@id='contentArea']"));
		List<WebElement> names = box.findElements(By.tagName("a"));
		System.out.println("Total friends -- "+ names.size());
		
		
		for(int i=0 ;i< names.size();i++){
			String frnd = names.get(i).getText();
			if(! frnd.trim().equals("")){
				System.out.println(frnd);
			}
		}
		
		
		
		
		
		
		
		

		
		
		
	}

}
