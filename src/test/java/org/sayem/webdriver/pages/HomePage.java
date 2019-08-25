package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver browser;

    public HomePage(WebDriver browser) {
        this.browser = browser;
    }

    public HomePage googleSearch(){
        browser.navigate().to("http://www.google.com");
        return this;
    }
}
