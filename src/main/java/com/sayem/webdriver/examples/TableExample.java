package com.sayem.webdriver.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TableExample {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/Locators.html");
    }

    @Test
    public void testWebTable() {

        WebElement simpleTable = driver.findElement(By.id("items"));

        //Get all rows
        List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
        assertEquals(3, rows.size());

        //Print data from each row
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.println();
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

