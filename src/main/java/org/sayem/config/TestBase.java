package org.sayem.config;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.web.WebPage;
import org.openqa.selenium.WebDriver;
import org.sayem.browser.Browser;
import org.sayem.browser.ChromeBrowser;
import org.sayem.listener.BrowserListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners({BrowserListener.class})
public class TestBase {

    private final String browserEnv = System.getProperty("browser");
    private Browser<WebDriver> webdriver;
    private Browser<WebPage> browser;


    @AfterMethod
    public void tearDown() throws InvocationException, HttpException {
        if (webdriver != null) {
            webdriver.driver().close();
        } else if (browser != null) {
            browser.driver().close();
        }
    }

    protected Browser<WebDriver> webDriver() {
        webdriver = new ChromeBrowser().webDriver();
        return webdriver;
    }

    protected Browser<WebPage> driver() throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException {
         browser = new ChromeBrowser().webPage("http://www.google.com");
         return browser;
    }
}