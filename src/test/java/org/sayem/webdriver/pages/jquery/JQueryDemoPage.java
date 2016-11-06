package org.sayem.webdriver.pages.jquery;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selenium.Browser;

/**
 * Created by sayem on 1/30/16.
 */
public class JQueryDemoPage {

    private Browser browser;

    public JQueryDemoPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public JQueryDemoPage draggable() {

        return this;
    }
}
