package org.sayem.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by sayem on 08/02/17.
 */
public interface SearchScope extends SearchContext {

    <T> T await(Function<SearchScope, T> function);

    default DelegatingElement findElement(Supplier<By> by) {
        return new DelegatingElement(await((e) -> e.findElement(by.get())));
    }

    default List<DelegatingElement> findElements(Supplier<By> by) {
        return await((e) -> e.findElements(by.get()).stream().map(DelegatingElement::new).collect(Collectors.toList()));
    }

    default Optional<DelegatingElement> optionalElement(Supplier<By> by) {
        try {
            return Optional.of(findElement(by));
        } catch (NoSuchElementException ignored) {
            return Optional.empty();
        }
    }

    default boolean isPresent(Supplier<By> by) {
        return optionalElement(by).isPresent();
    }
}

