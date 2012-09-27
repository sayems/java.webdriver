package com.sayem.module17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Amway {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.amway.com/Shop/Product/Category.aspx/Laundry-Apparel-Care");
		String xpath_start="//*[@id='ctl01_PlaceHolderMain_ctl00___ctl02___rptItems_ctl00_ctl00___rptHooks_ctl03_rptObjects_ctl0";
		String xpath_end="_btnAddToCart']";
		
		for(int i=0;i<=1;i++){
			driver.findElement(By.xpath(xpath_start+i+xpath_end)).click();
			
			
		}
		Thread.sleep(5000L);
 		String cart_items = driver.findElement(By.xpath("//*[@id='ctl01_ctl12___ctl00___ctl04___lnkItemsInCart']")).getText();
		System.out.println(cart_items);
		String tem[] = cart_items.split(" ");
		System.out.println(tem[0]);
	}

}
