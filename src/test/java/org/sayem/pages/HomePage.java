package org.sayem.pages;

import org.sayem.browser.Browser;

public class HomePage {

    private Browser browser;

    public HomePage(Browser browser) {
        this.browser = browser;
    }

    public HomePage googleSearch(){
        browser.driver().navigate().to("http://www.google.com");
        return this;
    }
}
