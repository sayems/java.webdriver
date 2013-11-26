package com.sayem.webdriver.basic.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*
 *
 * Learning basics of selenium. Locator stratergies
 *
 *
 *
 */

public class Gmail {


    // test the home page of Gmail
    @Test
    public void testHomePage(){

        System.setProperty("webdriver.chrome.driver", "H:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://gmail.com");

		/*
		WebElement username = driver.findElement(By.id("Email"));
		username.sendKeys("dummyname");

		WebElement password = driver.findElement(By.name("Passwd"));
		password.sendKeys("xxxxxxx");


		WebElement button = driver.findElement(By.id("signIn"));
		button.click();
		*/
		/*
		driver.findElement(By.id("Email")).sendKeys("dummyname");
		driver.findElement(By.name("Passwd")).sendKeys("xxxxx");
		driver.findElement(By.id("signIn")).click();
		*/

        // writing email into email field
        driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/form/div[1]/input")).sendKeys("hello");

        String x = driver.findElement(By.xpath("//div[@class='product-info mail']/p")).getText();
        System.out.println(x);

        //driver.findElement(By.className("g-button g-button-submit")).click();
        driver.findElement(By.xpath("//input[@class='g-button g-button-submit']")).click();


    }
}