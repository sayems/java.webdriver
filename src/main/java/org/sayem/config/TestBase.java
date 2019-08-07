package org.sayem.config;

import org.openqa.selenium.WebDriver;
import org.sayem.browser.Browser;
import org.sayem.listener.BrowserListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.util.Arrays;

import static org.sayem.browser.BrowserType.values;

@Listeners({BrowserListener.class})
public class TestBase {

    private final String browserEnv = System.getProperty("browser");
    private Browser<? extends WebDriver> browser;

    @AfterMethod
    public void tearDown() {
        browser.driver().close();
    }

    @SuppressWarnings("unchecked")
    protected <T> T getDriver() {
        browser = Arrays.asList(values())
                .parallelStream()
                .filter(s -> s.name().equalsIgnoreCase(browserEnv))
                .findFirst().get().driver.get().browser();
        return (T) browser;
    }
}