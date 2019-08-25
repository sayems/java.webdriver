package org.sayem.browser;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

public enum BrowserType {

    CHROME(ChromeBrowser::new),
    FIREFOX(FirefoxBrowser::new);

    public final ThreadLocal<WebAdapter> driver = new ThreadLocal<>();

    BrowserType(Supplier<WebAdapter> driver) {
        this.driver.set(requireNonNull(driver).get());
    }
}