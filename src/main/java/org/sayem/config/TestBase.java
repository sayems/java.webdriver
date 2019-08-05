package org.sayem.config;

import org.openqa.selenium.WebDriver;
import org.sayem.browser.Browser;
import org.sayem.listener.BrowserListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import static org.sayem.browser.BrowserType.CHROME;
import static org.sayem.browser.BrowserType.FIREFOX;

@Listeners({BrowserListener.class})
public class TestBase {

    private Browser<? extends WebDriver> browser;

    @AfterMethod
    public void tearDown() {
        browser.driver().quit();
    }

    @SuppressWarnings("unchecked")
    protected <T> T getDriver() {
        if (System.getProperty("browser").equalsIgnoreCase(String.valueOf(CHROME))) {
            browser = CHROME.browser.get();
        } else {
            browser = FIREFOX.browser.get();
        }
        return (T) browser;
    }
}
