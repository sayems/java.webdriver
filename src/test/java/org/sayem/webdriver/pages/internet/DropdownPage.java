package org.sayem.webdriver.pages.internet;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selectors.Id;
import org.sayem.webdriver.selenium.Browser;
import org.testng.Assert;

import static org.sayem.webdriver.selectors.Id.*;

/**
 * Created by sayem on 1/30/16.
 */
public class DropdownPage {

    private Browser browser;

    public DropdownPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public DropdownPage selectDropDown() {
        browser.untilFound(DROPDOWN_LIST);
        browser.getSelect().selectByText(DROPDOWN_LIST, "Option 1");
        Assert.assertEquals(browser.getSelect()
                .getFirstSelectedText(DROPDOWN_LIST), "Option 1");
        return this;
    }
}
