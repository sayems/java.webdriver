package org.sayem.browser;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements Adapter<FirefoxDriver> {

    @Override
    public Browser<FirefoxDriver> get() {
        return new BrowserAdapter<>(new FirefoxDriver());
    }
}
