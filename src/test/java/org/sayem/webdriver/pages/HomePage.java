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

    private void availableExamples(String example) {
        browser.findElements(CssSelector.AVAILABLE_EXAMPLES)
                .filter((s) -> s.getText().equals(example))
                .findAny().get().click();
    }

    public DropdownPage dropdown(){
        availableExamples("Dropdown");
        return TestBase.pageFactory(DropdownPage.class);
    }

    public CheckboxPage checkboxes(){
        availableExamples("Checkboxes");
        return TestBase.pageFactory(CheckboxPage.class);
    }
}
