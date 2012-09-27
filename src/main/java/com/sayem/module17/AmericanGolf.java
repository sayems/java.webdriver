package com.sayem.module17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AmericanGolf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//2 products of 6 -
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.americangolf.co.uk/Golf-Clubs/c4772.aspx");
		
		WebElement leftMenu= driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/div[3]/div/ul"));
		List<WebElement> leftLinks = leftMenu.findElements(By.tagName("a"));
		
		String xpath_catInfo_start="//*[@id='mainContent']/div[4]/div[";
		String xpath_catInfo_end="]/div/span";
		
		for(int i=0 ; i< leftLinks.size() ; i++){
			System.out.println("*********************");
			String linkText =leftLinks.get(i).getText();
			String temp[] = linkText.split("\\(");
			temp = temp[1].split("\\)");
			System.out.println("Text on left side -- "+ temp[0]);
			String infoText = driver.findElement(By.xpath(xpath_catInfo_start+(i+1)+xpath_catInfo_end)).getText();
			temp = infoText.split(" ");
			System.out.println("Text on right side -- "+ temp[3]);
		}
		

	}

}
