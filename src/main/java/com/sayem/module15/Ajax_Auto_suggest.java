package com.sayem.module15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Ajax_Auto_suggest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		int i =1;


		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//*[@id='body']/center/form/table/tbody/tr/td/div/input")).sendKeys("z");
		Thread.sleep(5000L);
		try{
			while(true){
				 String val = driver.findElement(By.xpath("//html/body/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr["+i+"]/td/div/table/tbody/tr/td/span")).getText();
				 System.out.println(val);
				 i++;
			}
		
		}catch(Exception e){
			System.out.println("iN catch "+i);
		}
		
		
	}

}
