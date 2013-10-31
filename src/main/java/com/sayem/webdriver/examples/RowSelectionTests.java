package com.sayem.webdriver.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RowSelectionTests {
	
	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://component-showcase.icesoft.org/component-showcase/showcase.iface");
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Row Selection")).click();
		driver.findElement(By.xpath("//table[@class='iceSelOneRb']/tbody/tr/td[2]/label")).click();
	}

	@Test
	public void testRowSelectionUsingControlKey() {
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));
				
		//Select second and fourth row from Table using Control Key.
		//Row Index start at 0
		Actions builder = new Actions(driver);
		builder.click(tableRows.get(1)).keyDown(Keys.CONTROL)
				.click(tableRows.get(3)).keyUp(Keys.CONTROL)
				.build().perform();
		
		//Verify Selected Row Table shows two rows selected
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
		assertEquals(2,rows.size());
		
		WebElement someElement = driver.findElement(By.name("ome"));
	
	}
	
	@Test
	public void testRowSelectionUsingShiftKey() {
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));

		//Select first row to fourth row from Table using Shift Key
		//Row Index start at 0
		Actions builder = new Actions(driver);
		builder.click(tableRows.get(0)).keyDown(Keys.SHIFT)
				.click(tableRows.get(1))
				.click(tableRows.get(2))
				.click(tableRows.get(3))
				.keyUp(Keys.SHIFT)
				.build().perform();
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
		assertEquals(4,rows.size());
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
