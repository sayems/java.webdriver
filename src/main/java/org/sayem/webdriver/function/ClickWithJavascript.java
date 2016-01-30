package org.sayem.webdriver.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.BiConsumer;

/**
 * Takes a {@code WebDriver} and {@code WebElement} as input parameters and uses {@link JavascriptExecutor} to perform
 * a click on the {@code WebElement}.
 * <p>
 * This lambda function is useful for executing clicks in situations where the {@link WebElement#click} method fails
 * silently. That is, the {@code WebElement#click} runs without throwing any {@code Exceptions}, but the element is
 * not actually clicked.
 * <p>
 * Created by sayem on 10/05/15.
 */
public class ClickWithJavascript implements BiConsumer<WebDriver, WebElement> {

    /**
     * Uses {@code JavascriptExecutor} with the specified driver to perform a click on the specified element.
     *
     * @param driver  the {@code WebDriver} to use with {@code JavascriptExecutor} for performing the click
     * @param element the {@code WebElement} to click
     */
    public void accept(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
