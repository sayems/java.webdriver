package org.sayem.testleft.pages;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.testobjects.web.WebElement;
import com.smartbear.testleft.testobjects.web.WebPage;
import org.sayem.browser.Browser;

public class HomePage {

    private Browser<WebPage> browser;

    public HomePage(Browser<WebPage> browser) {
        this.browser = browser;
    }

    public HomePage googleSearch() throws InvocationException, HttpException {
        browser.driver().querySelector(WebElement.class, "").click();
        return this;
    }
}
