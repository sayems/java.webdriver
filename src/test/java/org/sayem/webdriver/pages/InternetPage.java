package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.selectors.CssSelector;
import org.sayem.webdriver.selenium.Browser;

/**
 * Created by sayem on 1/30/16.
 */
public class InternetPage {

    private Browser browser;

    public InternetPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public DropdownPage goToDrownPage(){
        browser.findElements(CssSelector.AVAILABLE_EXAMPLES)
                .filter((s) -> s.getText().equals("Dropdown"))
                .findAny().get().click();
        return TestBase.pageFactory(DropdownPage.class);
    }
}
