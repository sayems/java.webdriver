package org.sayem;

import org.openqa.selenium.WebDriver;
import org.sayem.browser.Browser;
import org.sayem.browser.BrowserType;
import org.testng.annotations.AfterMethod;

public class TestBase {

    private Browser<? extends WebDriver> webdriver = BrowserType.CHROME.browser.get();


    @SuppressWarnings("unchecked")
    protected <T> T getDriver() {
        return (T) webdriver;
    }

    @AfterMethod
    public void tearDown(){
        webdriver.driver().quit();
    }
}
