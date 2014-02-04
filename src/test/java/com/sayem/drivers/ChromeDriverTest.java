package com.sayem.drivers;

import com.sayem.webdriver.examples.Driver;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * cover nuances with the Chrome Driver
 */
public class ChromeDriverTest {

    @BeforeClass
    public static void setupTheChromeDriverSystemProperty(){

        // tell webdriver where to find the chrome driver
        String currentDir = System.getProperty("user.dir");
        String chromeDriverLocation = currentDir + "/../tools/chromedriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);


    }

    @Test
    public void basicChromeUsage(){

        WebDriver chrome = new ChromeDriver();

        chrome.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(chrome.getTitle(), is("HTML Form Elements"));

        chrome.quit();
    }

    @Test
    /*
      * Chrome is supported by_class WebDriver, on linux it may not
      * find the location of your browser
      * the 'which' command for chromium-browser may find it
      */
    public void basicChromeDriverOptions(){

        // http://peter.sh/experiments/chromium-command-line-switches/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");

        WebDriver chrome = new ChromeDriver(options);

        chrome.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(chrome.getTitle(), is("HTML Form Elements"));

        chrome.quit();

    }


    @Test
    public void basicChromeDriverProxy(){

        // http://peter.sh/experiments/chromium-command-line-switches/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");
        options.addArguments("proxy-server=" + Driver.PROXY);

        WebDriver chrome = new ChromeDriver(options);

        chrome.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(chrome.getTitle(), is("HTML Form Elements"));

        chrome.quit();

    }



}
