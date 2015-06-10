package org.sayem.webdriver.basics.webdriver.examples;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HTML5VideoPlayer {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://dl.dropbox.com/u/55228056/html5video.html");
    }

    @Test
    public void testHTML5VideoPlayer() throws Exception {

        File scrFile = null;

        //Get the HTML5 Video Element
        WebElement videoPlayer = driver.findElement(By.id("vplayer"));

        //We will need a JavaScript Executor for interacting with Video Element's
        //methods and properties for automation
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get the Source of Video that will be played in Video Player
        String source = (String) jsExecutor.executeScript("return arguments[0].currentSrc;", videoPlayer);
        //Get the Duration of Video
        long duration = (Long) jsExecutor.executeScript("return arguments[0].duration", videoPlayer);

        //Verify Correct Video is loaded and duration
        assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
        assertEquals(25, duration);

        //Play the Video
        jsExecutor.executeScript("return arguments[0].play()", videoPlayer);

        Thread.sleep(5000);

        //Pause the video
        jsExecutor.executeScript("arguments[0].pause()", videoPlayer);

        //Take a screen-shot for later verification
        scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\pause_play.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}