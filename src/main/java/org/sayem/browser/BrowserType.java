package org.sayem.browser;

import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * Created by sayem on 08/02/17.
 */
public enum BrowserType {

    CHROME(ChromeBrowser::new),
    FIREFOX(FirefoxBrowser::new);

    public final ThreadLocal<Adapter<? extends WebDriver>> driver = new ThreadLocal<>();

    BrowserType(Supplier<Adapter<? extends WebDriver>> driver) {
        this.driver.set(requireNonNull(driver).get());
    }
}
