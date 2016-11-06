package org.sayem.webdriver;

import net.lightbody.bmp.BrowserMobProxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sayem.webdriver.browsers.config.BrowserThreads;
import org.sayem.webdriver.listeners.BrowserListener;
import org.sayem.webdriver.listeners.RetryListener;
import org.sayem.webdriver.listeners.ScreenshotListener;
import org.sayem.webdriver.listeners.TestNGListener;
import org.sayem.webdriver.properties.PropertiesUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sayem on 10/05/15.
 */
@Listeners({BrowserListener.class, TestNGListener.class,
        ScreenshotListener.class, RetryListener.class})
public abstract class TestBase {

    private static List<BrowserThreads> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<BrowserThreads> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<BrowserThreads>() {
            @Override
            protected BrowserThreads initialValue() {
                BrowserThreads webDriverThread = new BrowserThreads();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }

    public static void setBrowserUrl(String value) {
        System.setProperty("seleniumUrl", value);
    }

    public static String getProperties(Repository repository) {
        return PropertiesUtil.create(Repository.LOCATION.getValue()).data(repository);
    }


    public static WebDriver driver() {
        return driverThread.get().getDriver();
    }

    public static WebDriver browserMobProxyEnabledDriver() {
        return driverThread.get().getBrowserMobProxyEnabledDriver();
    }

    public static BrowserMobProxy browserMobProxy() {
        return driverThread.get().getBrowserMobProxy();
    }

    public static <T> T pageFactory(Class<T> clazz) {
        return PageFactory.initElements(driver(), clazz);
    }

    @AfterMethod(alwaysRun = true)
    public static void clearCookies() {
        TestBase.driver().manage().deleteAllCookies();
        TestBase.driver().navigate().refresh();
    }

    @AfterSuite(alwaysRun = true)
    public static void quitBrowser() {
        webDriverThreadPool.forEach(BrowserThreads::quitDriver);
    }
}
