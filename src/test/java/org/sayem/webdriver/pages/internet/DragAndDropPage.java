package org.sayem.webdriver.pages.internet;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selectors.Id;
import org.sayem.webdriver.selenium.Browser;

import static org.sayem.webdriver.selectors.Id.*;

/**
 * Created by sayem on 1/31/16.
 */
public class DragAndDropPage {

    private Browser browser;

    public DragAndDropPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    // TODO - doesn't work!
    public DragAndDropPage swapBoxes() {
        browser.untilFound(DRAG);
        browser.getAction().dragDrop(DRAG, DROP);
        return this;
    }
}
