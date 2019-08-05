package org.sayem.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by sayem on 08/02/17.
 */
public interface ExplicitWait extends SearchScope {

    default DelegatingElement await(Supplier<By> by) {
        return await((SearchScope e) -> e.findElement(by));
    }

    default void await(Predicate<SearchScope> predicate) {
        await((Function<SearchScope, Boolean>) predicate::test);
    }

    default <T> T await(Function<SearchScope, T> function) {
        return new FluentWait<>(this)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(Exception.class)
                .until(function::apply);
    }

    default WebElement untilFound(By by) {
        return new FluentWait<>(this)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class)
                .until((ExplicitWait e) -> e.findElement(by));
    }

    default DelegatingElement untilFound(Supplier<By> by) {
        return new FluentWait<>(this)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class)
                .until((ExplicitWait e) -> e.findElement(by));
    }

    default DelegatingElement untilFound(Supplier<By> by, int duration) {
        return new FluentWait<>(this)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class)
                .until((ExplicitWait e) -> e.findElement(by));
    }
}
