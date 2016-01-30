package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selenium.Browser;

/**
 * Created by sayem on 1/30/16.
 */
public class CheckboxPage {

    private Browser browser;

    public CheckboxPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public CheckboxPage selectCheckbox(){

        return this;
    }
}
