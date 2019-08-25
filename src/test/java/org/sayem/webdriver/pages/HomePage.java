package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.sayem.browser.Browser;

public class HomePage {

    private Browser<WebDriver> browser;

    public HomePage(Browser<WebDriver> browser) {
        this.browser = browser;
    }

    public HomePage googleSearch(){
        browser.driver().navigate().to("http://www.google.com");
        return this;
    }
}
