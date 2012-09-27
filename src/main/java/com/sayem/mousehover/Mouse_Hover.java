package com.sayem.mousehover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class Mouse_Hover {

	public static void main(String[] args) throws Exception {
		
		
		WebDriver Accessories = new FirefoxDriver();
			
		EventFiringWebDriver driver = new EventFiringWebDriver(Accessories);
		MyListener myListener = new MyListener();
		driver.register(myListener);
		EventFiringMouse mouse = new EventFiringMouse(driver , myListener);
		
		Accessories.navigate().to("http://google.com");
		Thread.sleep(2000);
		Accessories.findElement(By.name("email")).sendKeys("sayem@sayem.com");
		Accessories.findElement(By.name("password")).sendKeys("user123");
		Accessories.findElement(By.id("login")).click();
		Thread.sleep(3000);	
		Accessories.findElement(By.id("department-1")).click();
		Thread.sleep(200000);	
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='product-7138']/a/img"));
		Coordinates c= hoverItem.getCoordinates();					
		
		try{
			mouse.mouseMove(c);
			Thread.sleep(30000);
		}catch(Exception e1){
		
		}


		
				//}
				
		//Accessories.quit();
	}

}
