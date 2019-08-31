package org.sayem.config;

import org.sayem.browser.Browser;
import org.sayem.listener.BrowserListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.util.Arrays;

import static java.lang.System.*;
import static org.sayem.browser.BrowserType.values;

@Listeners({BrowserListener.class})
public class TestBase {

    private Browser<?> browser;

    @AfterMethod
    public void tearDown() {
        browser.driver().close();
    }

    protected <T> T getDriver() {
        browser = Arrays.asList(values())
                .parallelStream()
                .filter(s -> s.name()
                        .equalsIgnoreCase(getProperty("browser")))
                .findFirst().get().driver.get().browser();
        return (T) browser;
    }
}