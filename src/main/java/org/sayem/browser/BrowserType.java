package org.sayem.browser;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

public enum BrowserType {

    CHROME(ChromeBrowser::new);

    public final ThreadLocal<Adapter> driver = new ThreadLocal<>();

    BrowserType(Supplier<Adapter> driver) {
        this.driver.set(requireNonNull(driver).get());
    }
}