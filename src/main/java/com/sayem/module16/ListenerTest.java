package com.sayem.module16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class ListenerTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver web_driver = new FirefoxDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(web_driver);
		MyListener myListener = new MyListener();
		driver.register(myListener);
		
		driver.navigate().to("http://www.gmail.com");
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[1]/font/table/tbody/tr[3]/td[2]/font/a")).click();
		Thread.sleep(5000L);
		// back button
		System.out.println("Going to click back button");
		driver.navigate().back();
		System.out.println("Clicking back button");
		Thread.sleep(5000L);
		driver.navigate().forward();
		Thread.sleep(5000L);

		driver.quit();
	}

}
