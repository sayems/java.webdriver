package org.sayem.browser;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.web.WebPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by sayem on 08/02/17.
 */
public interface Adapter {
    Browser<WebPage> webPage(String url) throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException;
    Browser<WebDriver> webDriver();
}
