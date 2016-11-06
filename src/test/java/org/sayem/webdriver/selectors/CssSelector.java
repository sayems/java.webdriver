package org.sayem.webdriver.selectors;


import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.cssSelector;

/**
 * This enum is a Supplier of ByCssSelector from Selenium By API.
 * Created by sayem on 10/05/15.
 */
public enum CssSelector implements Supplier<By> {

    AVAILABLE_EXAMPLES("#content>ul>li>a"),
    CHECKBOX("#checkboxes > input:nth-of-type(1)"),
    BROKEN_IMAGE(".example>img"),;

    private final By by;

    CssSelector(String id) {
        this.by = cssSelector(id);
    }

    /**
     * @return the by instance variable which is a ByCssSelector.
     */
    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}

