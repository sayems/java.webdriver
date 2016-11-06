package org.sayem.webdriver.pages.internet;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.selectors.CssSelector;
import org.sayem.webdriver.selenium.Browser;

import static org.sayem.webdriver.selectors.CssSelector.*;

/**
 * Created by sayem on 1/30/16.
 */
public class HomePage {

    private Browser browser;

    public HomePage(WebDriver driver) {
        this.browser = new Browser(driver);
        browser.navigate().to("http://the-internet.herokuapp.com/");
    }

    private void availableExamples(String example) {
        browser.findElements(AVAILABLE_EXAMPLES)
                .filter((s) -> s.getText().equals(example))
                .findAny().get().click();
    }

    public DropdownPage dropdown() {
        availableExamples("Dropdown");
        return TestBase.pageFactory(DropdownPage.class);
    }

    public CheckboxPage checkboxes() {
        availableExamples("Checkboxes");
        return TestBase.pageFactory(CheckboxPage.class);
    }

    public DragAndDropPage dragAndDrop() {
        availableExamples("Drag and Drop");
        return TestBase.pageFactory(DragAndDropPage.class);
    }

    public BrokenImagePage brokenImage() {
        availableExamples("Broken Images");
        return TestBase.pageFactory(BrokenImagePage.class);
    }
}
