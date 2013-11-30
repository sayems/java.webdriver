package com.sayem.webdriver.basic.part5;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesforceLead {

    WebDriver driver =null;

    @Test
    public void createLead(){
        String firstName = "Harry";
        String lastName = "Potter";
        String company = "Hollywood";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://salesforce.com");
        driver.findElement(By.xpath("//*[@id='button-login']")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("loadrunnerjmeter@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("pass@1234");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='Lead_Tab']/a")).click();
        driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
        driver.findElement(By.xpath("//*[@id='name_firstlea2']")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id='name_lastlea2']")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id='lea3']")).sendKeys(company);
        driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();
        driver.findElement(By.xpath("//*[@id='Lead_Tab']/a")).click();
        driver.findElement(By.xpath("//*[@id='lead_summary']/table/tbody/tr[4]/td[3]/input")).click();
        boolean recordFound=false;
        // validations
        String part1="//*[@id='fchArea']/table/tbody/tr[";
        String part2="]/td[1]";
        int i=2;
        while(isElementPresent_xpath(part1+i+part2)){
            String fName = driver.findElement(By.xpath(part1+i+part2)).getText();
            if(fName.equals(firstName)){
                // last name
                String xpathLastNameCol = part1 + i + part2.replace("td[1]", "td[2]");
                String lName = driver.findElement(By.xpath(xpathLastNameCol)).getText();


                if(lName.equals(lastName)){
                    System.out.println(fName+" --- "+ lName);
                    recordFound = true;
                    break;
                }

            }

            i++;

        }

        Assert.assertTrue(recordFound, "Record of the lead created could not be found");

    }

    public boolean isElementPresent_xpath(String objectXpath){

        int count = driver.findElements(By.xpath(objectXpath)).size();
        if(count==0)
            return false;
        else
            return true;

    }


}