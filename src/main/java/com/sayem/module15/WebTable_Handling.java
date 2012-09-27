package com.sayem.module15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebTable_Handling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.espncricinfo.com/england-v-sri-lanka-2011/engine/match/474470.html");
		String xpath_start="//*[@id='inningsBat1']/tbody/tr[";
		String xpath_end="]/td[4]";
		
		int total=0;
		for(int i=3 ;i<=25 ; i=i+2){
		String x = driver.findElement(By.xpath(xpath_start + i + xpath_end)).getText();
			total =total + Integer.parseInt(x);
		}
		
		System.out.println("Total score -- "+ total);
		
		System.out.println("****************************");
		
		String start="//*[@id='inningsBat1']/tbody/tr[";
		String mid="]/td[";
		String end="]";
		
		
		for(int rowNum=3 ; rowNum<=21 ;rowNum=rowNum+2){
			
			for(int colNum=2; colNum<=9 ; colNum++){
				System.out.print(driver.findElement(By.xpath(start+rowNum+mid+colNum+end)).getText() + " ------ ");
			}
			System.out.println();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
