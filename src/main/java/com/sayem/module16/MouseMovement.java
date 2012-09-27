package com.sayem.module16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;


public class MouseMovement {

	
	public static void main(String[] args) {

		
		WebDriver web_driver = new FirefoxDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(web_driver);
		MyListener myListener = new MyListener();
		driver.register(myListener);
		
		driver.get("http://timesofindia.com");
		EventFiringMouse mouse = new EventFiringMouse(driver , myListener);
		// move mousehover
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("html/body/div[3]/table[3]/tbody/tr[1]/td[1]/div[12]/div[2]/div[2]/ul/li/a"));
		Coordinates c= hoverItem.getCoordinates();
		try{
			mouse.mouseMove(c);
		}catch(Exception e1){
			
			
		}
		// right click
		driver.findElement(By.xpath("html/body/div[3]/table[3]/tbody/tr[1]/td[1]/div[12]/div[2]/div[2]/ul/li/a")).sendKeys(Keys.chord(Keys.SHIFT,Keys.F10));
		// coordinates
		Point p=driver.findElement(By.xpath("html/body/div[3]/table[3]/tbody/tr[1]/td[1]/div[12]/div[2]/div[2]/ul/li/a")).getLocation();
		System.out.println(p.x);
		System.out.println(p.y);
		
		
		
		
	}

}
