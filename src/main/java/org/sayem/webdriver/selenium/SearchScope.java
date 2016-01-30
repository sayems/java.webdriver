package org.sayem.webdriver.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by sayem on 10/05/15.
 */
@SuppressWarnings("all")
public interface SearchScope {

    Element findElement(Supplier<By> by);

    default Optional<Element> optionalElement(Supplier<By> by) {
        try {
            return Optional.of(findElement(by));
        } catch (NoSuchElementException ignored) {
            return Optional.empty();
        }
    }
}