package org.sayem.webdriver.function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

/**
 * Takes a {@code WebElement}, a polling timeout and a polling interval as input parameters and uses a
 * {@link FluentWait} to poll the {@code WebElement} at the specified interval until it becomes invisible or the
 * polling timeout expires.
 * <p>
 * Created by sayem on 10/05/15.
 */
@SuppressWarnings("UnusedDeclaration")
public class WaitForElementNotVisible implements TriConsumer<WebElement, Integer, Integer> {

    /**
     * Polls the specified {@code WebElement} at the specified polling interval until it becomes invisible or the
     * polling timeout expires.
     *
     * @param element         the {@code WebElement} that is expected to become invisible
     * @param pollingTimeout  the polling timeout in seconds to poll the {@code WebElement} for visibility status
     * @param pollingInterval the polling interval in seconds between checks for the visibility status of the
     *                        {@code WebElement}
     */
    public void accept(WebElement element, Integer pollingTimeout, Integer pollingInterval) {
        new FluentWait<>(element)
                .withTimeout(pollingTimeout, TimeUnit.SECONDS)
                .pollingEvery(pollingInterval, TimeUnit.SECONDS)
                .until((WebElement element1) -> {
                    try {
                        return element1.isDisplayed();
                    } catch (NoSuchElementException | StaleElementReferenceException e) {
                        return true;
                    }
                });
    }
}
