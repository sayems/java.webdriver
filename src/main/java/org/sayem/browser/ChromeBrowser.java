package org.sayem.browser;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.WebBrowserPattern;
import com.smartbear.testleft.testobjects.WebPagePattern;
import com.smartbear.testleft.testobjects.web.WebBrowser;
import com.smartbear.testleft.testobjects.web.WebPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements Adapter {

    @Override
    public Browser<WebPage> webPage(String url) throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException {
        WebBrowser browser = new LocalDriver()
                .getApplications()
                .runBrowser(BrowserType.Chrome,
                        url);
        WebPage page = browser.find(WebBrowser.class, new WebBrowserPattern() {{
            ObjectIdentifier = BrowserType.Chrome.getValueString().toLowerCase();
        }}).find(WebPage.class, new WebPagePattern() {{
            URL = url;
        }});
        return new BrowserAdapter<>(page);
    }

    @Override
    public Browser<WebDriver> webDriver() {
        WebDriverManager.chromedriver().setup();
        return new BrowserAdapter<>(new ChromeDriver());
    }
}
