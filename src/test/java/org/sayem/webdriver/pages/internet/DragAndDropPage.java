package org.sayem.webdriver.pages.internet;

import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selectors.Id;
import org.sayem.webdriver.selenium.Browser;

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
        browser.untilFound(Id.DRAG);
        browser.getAction().dragDrop(Id.DRAG, Id.DROP);
        return this;
    }
}
