package org.sayem.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.selectors.CssSelector;
import org.sayem.webdriver.selenium.Browser;

/**
 * Created by sayem on 1/30/16.
 */
public class HomePage {

    private Browser browser;

    public HomePage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public DropdownPage goToDropdownPage(){
        browser.findElements(CssSelector.AVAILABLE_EXAMPLES)
                .filter((s) -> s.getText().equals("Dropdown"))
                .findAny().get().click();
        return TestBase.pageFactory(DropdownPage.class);
    }
}
