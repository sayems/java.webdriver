package org.sayem.webdriver.deprecated.webdriver.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandling {
    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:/Window.html");

        String window1 = driver.getWindowHandle();
        System.out.println("First Window Handle is: " + window1);

        WebElement link = driver.findElement(By.linkText("Google Search"));
        link.click();

        String window2 = driver.getWindowHandle();
        System.out.println("Second Window Handle is: " + window2);
        System.out.println("Number of Window Handles so for: "
                + driver.getWindowHandles().size());

        driver.switchTo().window(window1);

    }
}
