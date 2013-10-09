package com.sayem.browser.navigation;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Navs {

	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new ChromeDriver();
		
		File file = new File("src/navs.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);
		
		dr.get(filePath);
		Thread.sleep(1000);
		
//		����1���㼶��λ���ȶ�λul�ٶ�λli
		dr.findElement(By.className("nav")).findElement(By.linkText("About")).click();
		Thread.sleep(1000);
		
//		����2: ֱ�Ӷ�λlink
		dr.findElement(By.linkText("Home")).click();
		
		Thread.sleep(1000);
		System.out.println("browser will be close");
		dr.quit();	
	}

}
