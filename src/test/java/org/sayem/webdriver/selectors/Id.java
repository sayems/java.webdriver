package org.sayem.webdriver.selectors;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.id;

/**
 * This enum is a Supplier of ById from Selenium By API.
 * Created by sayem on 10/05/15.
 */
public enum Id implements Supplier<By> {
    DROPDOWN_LIST("dropdown"),
    DRAG("column-a"),
    DROP("column-b"),;
    private final By by;

    Id(String id) {
        this.by = id(id);
    }

    /**
     * @return the by instance variable which is a ById.
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