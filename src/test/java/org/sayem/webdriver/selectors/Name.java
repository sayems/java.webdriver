package org.sayem.webdriver.selectors;

import org.openqa.selenium.By;

import java.util.function.Supplier;

/**
 * This enum is a Supplier of ByName from Selenium By API.
 * Created by sayem on 10/05/15.
 */
public enum Name implements Supplier<By> {
    ;
    private final By by;

    Name(String id) {
        this.by = By.name(id);
    }

    /**
     * @return the by instance variable which is a ByName.
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