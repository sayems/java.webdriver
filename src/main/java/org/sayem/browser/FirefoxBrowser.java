package org.sayem.browser;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.WebBrowserPattern;
import com.smartbear.testleft.testobjects.WebPagePattern;
import com.smartbear.testleft.testobjects.web.WebBrowser;
import com.smartbear.testleft.testobjects.web.WebPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.smartbear.testleft.BrowserType.Firefox;

public class FirefoxBrowser implements WebAdapter<WebPage, WebDriver> {

    @Override
    public Browser<WebPage> webPage(String url) throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException {
        WebBrowser browser = new LocalDriver()
                .getApplications()
                .runBrowser(Firefox, url);
        WebPage page = browser.find(WebBrowser.class, new WebBrowserPattern() {{
            ObjectIdentifier = Firefox.getValueString().toLowerCase();
        }}).find(WebPage.class, new WebPagePattern() {{
            URL = url;
        }});
        return new TestLeftAdapter(page);
    }

    @Override
    public Browser<WebDriver> webDriver() {
        WebDriverManager.chromedriver().setup();
        return new WebDriverAdapter(new FirefoxDriver());
    }
}
