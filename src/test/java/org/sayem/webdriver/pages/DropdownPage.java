package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selectors.Id;
import org.sayem.webdriver.selenium.Browser;
import org.testng.Assert;

/**
 * Created by sayem on 1/30/16.
 */
public class DropdownPage {

    private Browser browser;

    public DropdownPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public DropdownPage selectDropDown(){
        browser.untilFound(Id.DROPDOWN_LIST);
        browser.getSelect().selectByText(Id.DROPDOWN_LIST, "Option 1");
        Assert.assertEquals(browser.getSelect()
                .getFirstSelectedText(Id.DROPDOWN_LIST), "Option 1");
        return this;
    }
}
