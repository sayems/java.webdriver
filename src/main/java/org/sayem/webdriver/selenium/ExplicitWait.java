package org.sayem.webdriver.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.sayem.webdriver.TestBase;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by sayem on 10/05/15.
 */
public interface ExplicitWait extends SearchScope {

    default Element untilFound(Supplier<By> by) {
        waitForPageToLoad();
        return new FluentWait<>(this)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoring(Exception.class)
                .until((ExplicitWait e) -> e.findElement(by));
    }

    default Element untilFound2(Supplier<By> by) {
        waitForPageToLoad();
        Element element = new FluentWait<>(this)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoring(Exception.class)
                .until((ExplicitWait e) -> e.findElement(by));
        element.setSearchContext(this);
        element.setLocator((ExplicitWait e) -> this.untilFound2(by));
        return element;
    }

    default Wait<WebDriver> fluentWait() {
        return new FluentWait<>(TestBase.driver())
                .withTimeout(1, TimeUnit.MINUTES)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoreAll(new ArrayList<Class<? extends Throwable>>() {
                    {
                        add(StaleElementReferenceException.class);
                        add(NoSuchElementException.class);
                        add(TimeoutException.class);
                        add(InvalidElementStateException.class);
                        add(WebDriverException.class);
                    }
                }).withMessage("The message you will see in if a TimeoutException is thrown");
    }

    default void waitForPageToLoad() {
        waitForLoaderToComplete();
        waitForAjaxToComplete();
        waitForJavaScriptToComplete();
    }

    default void waitForLoaderToComplete() {
        Wait<WebDriver> wait = fluentWait();
        wait.until(loaderHasFinishProcessing());
    }

    default void waitForJavaScriptToComplete() {
        Wait<WebDriver> wait = fluentWait();
        wait.until(javaScriptHasFinishProcessing());
    }

    default void waitForAjaxToComplete() {
        Wait<WebDriver> wait = fluentWait();
        wait.until(jQuryHasFinishedProcessing());
    }

    default void waitForAngularToComplete() {
        Wait<WebDriver> wait = fluentWait();
        wait.until(angularHasFinishedProcessing());
    }

    default ExpectedCondition<Boolean> javaScriptHasFinishProcessing() {
        return driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete");
    }

    default ExpectedCondition<Boolean> loaderHasFinishProcessing() {
        return driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (window.show===false) || (window.show===undefined);");
    }

    default ExpectedCondition<Boolean> jQuryHasFinishedProcessing() {
        return driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
    }

    default ExpectedCondition<Boolean> angularHasFinishedProcessing() {
        return driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                .executeScript("return (window.angular !== undefined) &&" +
                        " (angular.element(document).injector() !== undefined) &&" +
                        " (angular.element(document).injector().get('$http')" +
                        ".pendingRequests.length === 0)").toString());
    }
}
