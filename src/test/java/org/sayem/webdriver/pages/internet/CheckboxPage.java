package org.sayem.webdriver.pages.internet;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selectors.CssSelector;
import org.sayem.webdriver.selenium.Browser;
import org.testng.Assert;

import static org.sayem.webdriver.selectors.CssSelector.*;

/**
 * Created by sayem on 1/30/16.
 */
public class CheckboxPage {

    private Browser browser;

    public CheckboxPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public CheckboxPage selectCheckbox() {
        browser.setCheckboxValue(CHECKBOX, true);
        Assert.assertTrue(browser.isChecked(CHECKBOX));
        return this;
    }
}
