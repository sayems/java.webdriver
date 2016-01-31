package org.sayem.webdriver.deprecated.dimension;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetHeight {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.navigate().to("http://www.google.com");
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.quit();

    }
}
