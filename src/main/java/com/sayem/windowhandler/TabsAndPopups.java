package com.sayem.windowhandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class TabsAndPopups {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.hdfc.com");
		
		System.out.println("*************Before clicking********************");
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> iter= windowids.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

		driver.findElement(By.xpath("html/body/div/div[2]/div[2]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("html/body/div/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a")).click();
		
		System.out.println("**************After clicking the tab link********************");
		
		 windowids = driver.getWindowHandles();
		 iter= windowids.iterator();
		 String mainWindowId=iter.next();
		 String tabbedWindowId=iter.next();
		 System.out.println(mainWindowId);
		 System.out.println(tabbedWindowId);
		Thread.sleep(3000L);
		// switch over to popup/tab
		driver.switchTo().window(tabbedWindowId);
		driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/p[2]/a")).click();
		System.out.println("********* AFTER CLICKING THE POPUP LINK");
		 windowids = driver.getWindowHandles();
		 iter= windowids.iterator();
		 iter.next();
		 iter.next();
		 String popupwindowid=iter.next();
		 System.out.println(mainWindowId);
		 System.out.println(tabbedWindowId);
		 System.out.println(popupwindowid);
		 driver.switchTo().window(popupwindowid);
		 driver.findElement(By.xpath("html/body/table/tbody/tr/td/table[2]/tbody/tr/td/table[1]/tbody/tr[4]/td/p/font/b/a")).click();
		 driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td/div[2]/div[1]/div[2]/div[2]/div[1]/select")).sendKeys("Goa");
		 
		 driver.close(); // close the popup
		 driver.switchTo().window(tabbedWindowId);
		 driver.close(); // tab - new window
		 driver.switchTo().window(mainWindowId);
		 driver.close(); // main window
		 
		
	}

}
