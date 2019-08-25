package org.sayem.browser;

import com.smartbear.testleft.testobjects.web.WebPage;

public class TestLeftAdapter implements Browser<WebPage> {

    private WebPage driver;

    TestLeftAdapter(WebPage driver) {
        this.driver = driver;
    }

    @Override
    public WebPage driver() {
        return driver;
    }
}
