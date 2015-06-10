package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class WindowPopupTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/Config.html");
    }

    @AfterClass
    public static void tearDown() {
        //Close the Parent Popup Window
        driver.close();
        driver.quit();
    }

    @Test
    public void testWindowPopup() {
        //Save the WindowHandle of Parent Browser Window
        String parentWindowId = driver.getWindowHandle();

        //Clicking Help Button will open Help Page in a new Popup Browser Window
        WebElement helpButton = driver.findElement(By.id("helpbutton"));
        helpButton.click();

        try {
            //Switch to the Help Popup Browser Window
            driver.switchTo().window("HelpWindow");
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }

        //Verify the driver context is in Help Popup Browser Window
        assertTrue(driver.getTitle().equals("Help"));

        //Close the Help Popup Window
        driver.close();

        //Move back to the Parent Browser Window
        driver.switchTo().window(parentWindowId);
        //Verify the driver context is in Parent Browser Window
        assertTrue(driver.getTitle().equals("Build my Car - Configuration"));
    }

    @Test
    public void testWindowPopupUsingTitle() {
        //Save the WindowHandle of Parent Browser Window
        String parentWindowId = driver.getWindowHandle();

        //Clicking Visit Us Button will open Visit Us Page in a new Popup Browser Window
        WebElement visitButton = driver.findElement(By.id("visitbutton"));
        visitButton.click();

        //Get Handles of all the open Popup Windows
        //Iterate through the set and check if tile of each window matches with expected Window Title
        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {

                try {
                    if (driver.switchTo().window(windowId).getTitle().equals("Visit Us")) {
                        //Close the Visit Us Popup Window
                        driver.close();
                        break;
                    }
                } catch (NoSuchWindowException e) {
                    e.printStackTrace();
                }
            }
        }

        //Move back to the Parent Browser Window
        driver.switchTo().window(parentWindowId);
        //Verify the driver context is in Parent Browser Window
        assertTrue(driver.getTitle().equals("Build my Car - Configuration"));
    }

    @Test
    public void testWindowPopupUsingContents() {
        //Save the WindowHandle of Parent Browser Window
        String currentWindowId = driver.getWindowHandle();

        //Clicking Chat Button will open Chat Page in a new Popup Browser Window
        WebElement chatButton = driver.findElement(By.id("chatbutton"));
        chatButton.click();

        //There is no name or title provided for Chat Page Popup
        //We will iterate through all the open Windows and check the contents to find
        //out if it's Chat Window
        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                driver.switchTo().window(windowId);

                if (driver.getPageSource().contains("Build my Car - Configuration - Online Chat")) {
                    try {

                        //Find the Close Button on Chat Popup Window and close the Popup
                        //by_class clicking Close Button instead of closing it directly
                        WebElement closeButton = driver.findElement(By.id("closebutton"));
                        closeButton.click();
                        break;
                    } catch (NoSuchWindowException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //Move back to the Parent Browser Window
        driver.switchTo().window(currentWindowId);
        //Verify the driver context is in Parent Browser Window
        assertTrue(driver.getTitle().equals("Build my Car - Configuration"));
    }
}
