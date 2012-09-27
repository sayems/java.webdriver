package com.sayem.module12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class RadioButtons {
	
	public static void main(String[] args) {
	
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		List<WebElement> radio = driver.findElements(By.name("group1"));
		
		System.out.println(radio.get(0).getAttribute("Value") + " -- " + radio.get(0).getAttribute("checked"));
		System.out.println(radio.get(1).getAttribute("Value") + " -- " + radio.get(1).getAttribute("checked"));
		System.out.println(radio.get(2).getAttribute("Value") + " -- " + radio.get(2).getAttribute("checked"));
		
		
		
		radio.get(0).click();
		
		System.out.println("********************************");
		
		System.out.println(radio.get(0).getAttribute("Value") + " -- " + radio.get(0).getAttribute("checked"));
		System.out.println(radio.get(1).getAttribute("Value") + " -- " + radio.get(1).getAttribute("checked"));
		System.out.println(radio.get(2).getAttribute("Value") + " -- " + radio.get(2).getAttribute("checked"));
		
		
		
	
	
	}

}
