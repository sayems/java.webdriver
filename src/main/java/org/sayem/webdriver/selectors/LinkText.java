package org.sayem.webdriver.selectors;


import org.openqa.selenium.By;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.openqa.selenium.By.linkText;

/**
 * This enum is a Supplier of ByLinkText from Selenium By API.
 * Created by sayem on 10/05/15.
 */
public enum LinkText implements Supplier<By> {
    ;
    private final By by;
    private final String text;

    LinkText(String text) {
        this.by = linkText(text);
        this.text = text;
    }

    public static LinkText resolve(String text) {
        return Stream.of(values()).filter((LinkText t) -> t.text.equals(text)).findFirst().get();
    }

    /**
     * @return the by instance variable which is a ByLinkText.
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
