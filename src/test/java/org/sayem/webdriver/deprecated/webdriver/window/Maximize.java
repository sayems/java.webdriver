package org.sayem.webdriver.deprecated.webdriver.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Maximize {

    WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        driver = new ChromeDriver();
    }


    @Test
    public void maximize() {
        //declare varibales for windows
        org.openqa.selenium.Dimension defaultDim;
        org.openqa.selenium.Dimension maximizeDim;

        //Load google website on browser
        driver.get("http://google.com");

        //Display the current screen dimensions
        defaultDim = driver.manage().window().getSize();
        System.out.println("screenHeight before maximizing " + defaultDim.getHeight());
        System.out.println("screenWidth before maximizing " + defaultDim.getWidth());

        //maximize the window using webdriver method
        driver.manage().window().maximize();

        //Display the maximized window dimensions
        maximizeDim = driver.manage().window().getSize();
        System.out.println("screenHeight after maximizing: " + maximizeDim.getHeight());
        System.out.println("screenWidth after maximizing: " + maximizeDim.getWidth());

    }


}