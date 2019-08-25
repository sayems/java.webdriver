package org.sayem.browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by sayem on 08/02/17.
 */
public class WebDriverAdapter implements Browser<WebDriver> {

    private WebDriver driver;

    WebDriverAdapter(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver driver() {
        return driver;
    }
}
