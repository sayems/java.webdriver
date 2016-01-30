package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selectors.CssSelector;
import org.sayem.webdriver.selectors.Id;
import org.sayem.webdriver.selenium.Browser;
import org.testng.Assert;

/**
 * Created by sayem on 1/30/16.
 */
public class CheckboxPage {

    private Browser browser;

    public CheckboxPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public CheckboxPage selectCheckbox(){
        browser.setCheckboxValue(CssSelector.CHECKBOX, true);
        Assert.assertTrue(browser.isChecked(CssSelector.CHECKBOX));
        return this;
    }
}
