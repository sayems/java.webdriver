package org.sayem.webdriver.basics.webdriver.basic.part3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AllLinks {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://bbc.com");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links -> " + allLinks.size());

        // 35th
        WebElement link35 = allLinks.get(34);
        //System.out.println(link35);
        //System.out.println(link35.getText());


        for (int i = 0; i < allLinks.size(); i++) {
            System.out.println(allLinks.get(i).getText() + " ---- " + allLinks.get(i).isDisplayed());
        }
        // screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\bbc.jpg"));


        // hidden , no text

    }

}
