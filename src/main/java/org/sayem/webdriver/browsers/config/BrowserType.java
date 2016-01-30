package org.sayem.webdriver.browsers.config;

import org.sayem.webdriver.browsers.*;

/**
 * Created by sayem on 10/05/15.
 */
public enum BrowserType {
    FIREFOX(new FirefoxBrowser()),
    CHROME(new ChromeBrowser()),
    IE(new IEBrowser()),
    SAFARI(new SafariBrowser()),
    OPERA(new OperaBrowser()),
    PHANTOMJS(new PhantomJSBrowser());

    public final IBrowserThreads browser;

    BrowserType(IBrowserThreads browser) {
        this.browser = browser;
    }
}