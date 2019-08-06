package org.sayem.config;

import org.openqa.selenium.WebDriver;
import org.sayem.browser.Browser;
import org.sayem.listener.BrowserListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static org.sayem.browser.BrowserType.values;

@Listeners({BrowserListener.class})
public class TestBase {

    private Browser<? extends WebDriver> browser;

    @AfterMethod
    public void tearDown() {
        browser.driver().close();
    }

    @SuppressWarnings("unchecked")
    protected <T> T getDriver() {
        browser = Stream.of(values())
                .parallel()
                .filter(s -> s.name()
                        .equalsIgnoreCase(System.getProperty("browser")))
                .findFirst().get().driver.get().browser();
        return (T) browser;
    }
}
