package org.sayem.webdriver.deprecated.select;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectExample {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new FirefoxDriver();
        driver.navigate().to("http://seleniumhq.org/docs/03_webdriver.html#user-input-filling-in-forms");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void selectByIndex() {
        Select select = new Select(driver.findElement(By.xpath("//select")));
        select.deselectAll();
        select.selectByVisibleText("Edam");
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }


}
