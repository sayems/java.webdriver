package org.sayem.config;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.TestProcess;
import com.smartbear.testleft.testobjects.web.WebPage;
import org.openqa.selenium.WebDriver;
import org.sayem.browser.Browser;
import org.sayem.browser.BrowserType;
import org.sayem.browser.Desktop;
import org.sayem.listener.BrowserListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners({BrowserListener.class})
public class TestBase {

    private final String browserEnv = System.getProperty("browser");
    private Browser<WebDriver> webdriver;
    private Browser<WebPage> browser;
    private Browser<TestProcess> desktop;


    @AfterMethod
    public void tearDown() throws InvocationException, HttpException {
        if (webdriver != null) {
            webdriver.driver().close();
        } else if (browser != null) {
            browser.driver().close();
        }
    }

    protected Browser<WebDriver> webDriver() {
        webdriver = BrowserType.CHROME.driver.get().webDriver();
        return webdriver;
    }

    protected Browser<WebPage> driver() throws TestAgentRunException,
            RestConnectionRefused, HttpException, ApiException {
        browser = BrowserType.CHROME.driver.get().webPage("http://www.google.com");
        return browser;
    }

    protected Browser<TestProcess> desktop() throws HttpException, ApiException, RestConnectionRefused, TestAgentRunException {
        desktop = new Desktop().webPage("notepad.exe");
        return desktop;
    }
}