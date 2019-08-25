package org.sayem.config;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.WebBrowserPattern;
import com.smartbear.testleft.testobjects.WebPagePattern;
import com.smartbear.testleft.testobjects.web.WebBrowser;
import com.smartbear.testleft.testobjects.web.WebPage;
import org.openqa.selenium.WebDriver;
import org.sayem.browser.SeleniumChrome;
import org.sayem.browser.TestLeftChrome;
import org.sayem.listener.BrowserListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners({BrowserListener.class})
public class TestBase {

    private final String browserEnv = System.getProperty("browser");
    private WebDriver webdriver;
    private WebBrowser browser;


    @AfterMethod
    public void tearDown() throws InvocationException, HttpException {
        if (webdriver != null) {
            webdriver.close();
        } else if (browser != null) {
            browser.close();
        }
    }

    protected WebDriver webDriver() {
        webdriver = new SeleniumChrome().browser().driver();
        return webdriver;
    }

    protected WebPage driver() throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException {

        WebBrowser browser = new TestLeftChrome().browser().driver().getApplications().runBrowser(BrowserType.Chrome,
                "http://www.google.com");

        return browser.find(WebBrowser.class, new WebBrowserPattern() {{
            ObjectIdentifier = BrowserType.Chrome.getValueString().toLowerCase();
        }}).find(WebPage.class, new WebPagePattern() {{
            URL = "http://www.google.com";
        }});
    }
}