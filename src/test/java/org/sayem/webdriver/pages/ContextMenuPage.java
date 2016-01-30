package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selenium.Browser;

/**
 * Created by sayem on 1/30/16.
 */
public class ContextMenuPage {

    private Browser browser;

    public ContextMenuPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public ContextMenuPage selectContextMenu(){

        return this;
    }
}
